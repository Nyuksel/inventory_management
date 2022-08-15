package com.nurdan.inventorymanegementsystem.dto;

import com.sun.istack.NotNull;
import com.nurdan.inventorymanegementsystem.entity.Category;
import com.nurdan.inventorymanegementsystem.entity.ProductOperations;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    private String userRole;
    private List<ProductOperations> productOperationsList;
    private List<Category> categoryList;
}
