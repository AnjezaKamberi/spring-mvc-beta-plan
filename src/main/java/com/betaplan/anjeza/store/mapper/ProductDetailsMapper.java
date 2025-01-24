package com.betaplan.anjeza.store.mapper;

import com.betaplan.anjeza.store.dto.ProductDetailsDTO;
import com.betaplan.anjeza.store.model.ProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface ProductDetailsMapper extends BaseMapper<ProductDetails, ProductDetailsDTO> {

    @Override
    @Named("toEntityDetails")
    ProductDetails toEntity(ProductDetailsDTO dto);

    @Override
    @Named("toDTODetails")
    ProductDetailsDTO toDTO(ProductDetails entity);
}
