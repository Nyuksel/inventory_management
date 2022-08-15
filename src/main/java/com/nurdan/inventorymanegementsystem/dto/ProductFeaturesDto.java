package com.nurdan.inventorymanegementsystem.dto;

import com.sun.istack.NotNull;
import com.nurdan.inventorymanegementsystem.entity.Product;
import lombok.Data;

@Data
public class ProductFeaturesDto {
    private Long id;
    @NotNull
    private String featuresName;
    private Product product;
}
