package com.betaplan.anjeza.store.mapper;

import com.betaplan.anjeza.store.dto.CategoryDTO;
import com.betaplan.anjeza.store.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Objects;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {

    @Override
    @Mapping(source = "description", target = "name")
    Category toEntity(CategoryDTO dto);

    @Override
    @Mapping(source = "name", target = "description")
    CategoryDTO toDTO(Category entity);

    @Override
    default List<Category> toEntityList(List<CategoryDTO> dtos) {
        return Objects.nonNull(dtos) ? dtos.stream().map(this::toEntity).toList() : null;
    }

    @Override
    default List<CategoryDTO> toDTOList(List<Category> entities) {
        return Objects.nonNull(entities) ? entities.stream().map(this::toDTO).toList() : null;
    }
}
