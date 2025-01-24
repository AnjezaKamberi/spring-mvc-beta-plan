package com.betaplan.anjeza.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDetailsDTO {

    private Integer id;
    private String description;
    private String manufacturer;
    private String warrantyPeriod;
}
