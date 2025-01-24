package com.betaplan.anjeza.store.service;

import com.betaplan.anjeza.store.dto.CategoryDTO;
import com.betaplan.anjeza.store.mapper.CategoryMapper;
import com.betaplan.anjeza.store.model.Category;
import com.betaplan.anjeza.store.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO create a common service
@Service
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CategoryDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }
}
