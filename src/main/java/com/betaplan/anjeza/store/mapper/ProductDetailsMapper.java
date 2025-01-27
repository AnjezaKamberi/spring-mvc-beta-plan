package com.betaplan.anjeza.store.mapper;

import com.betaplan.anjeza.store.dto.ProductDetailsDTO;
import com.betaplan.anjeza.store.model.ProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductDetailsMapper extends BaseMapper<ProductDetails, ProductDetailsDTO> {

    ProductDetailsMapper PRODUCT_DETAILS_MAPPER = Mappers.getMapper(ProductDetailsMapper.class);

    @Override
    @Named("toEntityDetails")
    ProductDetails toEntity(ProductDetailsDTO dto);

    @Override
    @Named("toDTODetails")
    ProductDetailsDTO toDTO(ProductDetails entity);

//    @Override
//    List<ProductDetails> toEntityList(List<ProductDetailsDTO> dtos);

//    @Override
//    List<ProductDetailsDTO> toDTOList(List<ProductDetails> entities);
}
