package com.betaplan.anjeza.store.mapper;

import com.betaplan.anjeza.store.dto.CategoryDTO;
import com.betaplan.anjeza.store.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {

    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    @Override
    @Mapping(source = "description", target = "name")
    @Mapping(target = "products", ignore = true)
    Category toEntity(CategoryDTO dto);

    @Override
    @Mapping(source = "name", target = "description")
    CategoryDTO toDTO(Category entity);

    @Override
    default List<Category> toEntityList(List<CategoryDTO> dtos) {
        return Objects.nonNull(dtos) ? dtos.stream().map(this::toEntity).collect(Collectors.toList()) : null;
    }

    @Override
    default List<CategoryDTO> toDTOList(List<Category> entities) {
        return Objects.nonNull(entities) ? entities.stream().map(this::toDTO).collect(Collectors.toList()) : null;
    }
}
