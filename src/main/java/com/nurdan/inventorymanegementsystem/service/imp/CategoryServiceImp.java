package com.nurdan.inventorymanegementsystem.service.imp;

import com.nurdan.inventorymanegementsystem.dto.CategoryDto;
import com.nurdan.inventorymanegementsystem.entity.Category;
import com.nurdan.inventorymanegementsystem.repo.CategoryRepository;
import com.nurdan.inventorymanegementsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(CategoryDto dto) {
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setUser(dto.getUser());
        categoryRepository.save(category);
        return category;
    }
    @Override
    public Boolean deleteCategory(Long id) {
        Category category = categoryRepository.getById(id);
        if(category != null){
            categoryRepository.delete(category);
            return true;
        }
        return false;
    }
    @Override
    public List<Category> listAll() {
        List<Category> list = categoryRepository.findAll();
        return list;
    }
}