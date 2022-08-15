package com.nurdan.inventorymanegementsystem.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private Long id;
    @NotNull
    private String productName;
    @NotNull
    private Integer amountOfProduct;
    private CategoryDto categoryDto;
    private List<ProductOperationsDto> productFeaturesDto;
    private List<ProductFeaturesDto> productOperationsDto;
}
