package com.betaplan.anjeza.store.mapper;

import com.betaplan.anjeza.store.dto.ProductDTO;
import com.betaplan.anjeza.store.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper extends BaseMapper<Product, ProductDTO> {

    @Override
    @Mapping(source = "stock", target = "quantity")
    @Mapping(source = "dto.categoryId", target = "id")
    @Mapping(source = "dto.categoryName", target = "name")
    Product toEntity(ProductDTO dto);

    @Override
    @Mapping(source = "quantity", target = "stock")
    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "id", target = "categoryName")
    ProductDTO toDTO(Product entity);
}
