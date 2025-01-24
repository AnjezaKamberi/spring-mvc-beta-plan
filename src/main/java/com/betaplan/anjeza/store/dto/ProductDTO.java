package com.betaplan.anjeza.store.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO - Data Transfer Object
 * - transfer data between layers of the application;
 * - contain only data that needs to be transferred;
 * - combine multiple database columns in a single field, or exclude fields from entity that are not needed
 * - apply validation rules different from entity's internal validation
 * - keep the BL and PL decoupled from how data is presented and consumed, so u can change one layer without affecting the other
 */
@Data
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private Integer stock;
    private Integer categoryId;
    private String categoryName;
    private ProductDetailsDTO productDetails;

}
