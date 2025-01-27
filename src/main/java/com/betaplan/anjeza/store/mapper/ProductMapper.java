package com.betaplan.anjeza.store.mapper;

import com.betaplan.anjeza.store.dto.ProductDTO;
import com.betaplan.anjeza.store.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

// TODO have a look at : https://www.baeldung.com/mapstruct; https://medium.com/@tijl.b/a-guide-to-mapstruct-with-spring-boot-vavr-lombok-d5325b436220
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ProductDetailsMapper.class)
public interface ProductMapper extends BaseMapper<Product, ProductDTO> {

//    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    @Override
    @Mapping(source = "stock", target = "quantity")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "categoryName", target = "category.name")
//    // TODO have a look at https://www.baeldung.com/mapstruct-custom-mapper
    @Mapping(source = "productDetails", target = "productDetails", qualifiedByName = "toEntityDetails")
//    @Mapping(target = "productDetails", ignore = true)
    Product toEntity(ProductDTO dto);

    @Override
    @Mapping(source = "quantity", target = "stock")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "productDetails", target = "productDetails", qualifiedByName = "toDTODetails")
//    @Mapping(target = "productDetails", ignore = true)
//    // TODO in case that you want to ignore mapping of a field, have a look at: https://www.baeldung.com/mapstruct-ignore-unmapped-properties
//    @Mapping(target = "field", ignore = true)
    ProductDTO toDTO(Product entity);
}
