package com.betaplan.anjeza.store.mapper;

import com.betaplan.anjeza.store.dto.CategoryDTO;
import com.betaplan.anjeza.store.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {

    @Override
    @Mapping(source = "description", target = "name")
    Category toEntity(CategoryDTO dto);

    @Override
    @Mapping(source = "name", target = "description")
    CategoryDTO toDTO(Category entity);
}
