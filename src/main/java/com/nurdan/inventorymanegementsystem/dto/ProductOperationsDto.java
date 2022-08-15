package com.nurdan.inventorymanegementsystem.dto;

import com.sun.istack.NotNull;
import com.nurdan.inventorymanegementsystem.entity.Product;
import com.nurdan.inventorymanegementsystem.entity.User;
import lombok.Data;

@Data
public class ProductOperationsDto {
    private Long id;
    @NotNull
    private Integer amountOfOperation;
    @NotNull
    private Product products;
    @NotNull
    private User users;
}