package com.nurdan.inventorymanegementsystem.service;

import com.nurdan.inventorymanegementsystem.dto.CategoryDto;
import com.nurdan.inventorymanegementsystem.entity.Category;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryService {
    @Transactional
    Category saveCategory(CategoryDto dto);
    @Transactional
    Boolean deleteCategory(Long id);
    List<Category> listAll ();
}