package com.betaplan.anjeza.store.service;

import com.betaplan.anjeza.store.dto.CategoryDTO;
import com.betaplan.anjeza.store.exceptions.CategoryFoundException;
import com.betaplan.anjeza.store.model.Category;
import com.betaplan.anjeza.store.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.betaplan.anjeza.store.mapper.CategoryMapper.CATEGORY_MAPPER;

//TODO create a common service
@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /*
    private CategoryDTO convertToDTO(Category category) {
        return new CategoryDTO(
                category.getId().intValue(),
                category.getName()
        );
    }

    private Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        if (categoryDTO.getId() != null) {
            category.setId(categoryDTO.getId().longValue());
        }
        category.setName(categoryDTO.getDescription());
        return category;
    }
    */

    public CategoryDTO saveCategory(CategoryDTO categoryDTO) throws CategoryFoundException {
        Category category;
        if (Objects.nonNull(categoryDTO.getId())) {
            category =  categoryRepository.findById(categoryDTO.getId()).get();
            category.setName(categoryDTO.getDescription());
        } else {
            category = CATEGORY_MAPPER.toEntity(categoryDTO);
        }
        if(Objects.nonNull(categoryRepository.findByName(category.getName()))){
            throw new CategoryFoundException("Category already exists.");
        }
        CategoryDTO savedCategory = CATEGORY_MAPPER.toDTO(categoryRepository.save(category));
        // with DTO's changes are not automatically propagated to the database unless explicitly converted and saved
        category.setName("new name");
        return savedCategory;
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return CATEGORY_MAPPER.toDTOList(categories);
    }

    public CategoryDTO getCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(CATEGORY_MAPPER::toDTO).orElse(null);
    }

    public boolean deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
