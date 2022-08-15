package com.nurdan.inventorymanegementsystem.dto;

import com.sun.istack.NotNull;
import com.nurdan.inventorymanegementsystem.entity.Product;
import com.nurdan.inventorymanegementsystem.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long id;
    @NotNull
    private String categoryName;
    @NotNull
    private User user;
    private List<Product> productList;
}
