package com.nurdan.inventorymanegementsystem.controller;

import com.nurdan.inventorymanegementsystem.dto.CategoryDto;
import com.nurdan.inventorymanegementsystem.entity.Category;
import com.nurdan.inventorymanegementsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    public final CategoryService categoryService;

    @PostMapping(value = "/save")
    public ResponseEntity<Category> saveCategory(@Validated @RequestBody CategoryDto dto){
        return ResponseEntity.ok(categoryService.saveCategory(dto));
    }

    @GetMapping(value = "/delete")
    public Boolean deleteCategory(@Validated @RequestParam Long id){
        return categoryService.deleteCategory(id);
    }

    @GetMapping(value = "/listAll")
    public List<Category> listAllCategory(){
        return categoryService.listAll();
    }
}