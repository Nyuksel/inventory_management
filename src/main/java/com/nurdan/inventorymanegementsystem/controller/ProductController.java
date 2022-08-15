package com.nurdan.inventorymanegementsystem.controller;

import com.nurdan.inventorymanegementsystem.dto.ProductDto;
import com.nurdan.inventorymanegementsystem.entity.Category;
import com.nurdan.inventorymanegementsystem.entity.Product;
import com.nurdan.inventorymanegementsystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    public final ProductService productService;

    @PostMapping(value = "/save")
    public ResponseEntity<Product> save(@Validated @RequestBody ProductDto dto){
        return ResponseEntity.ok(productService.saveProduct(dto));
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Product> update(@Validated @RequestBody ProductDto dto){
        Product product = productService.updateProductCategory(dto);
        if (product!= null){
            return ResponseEntity.ok(product);
        }
        return null;
    }

    @GetMapping(value = "/delete")
    public Boolean deleteProduct(@RequestParam Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping(value = "/listAll")
    public List<Product> listAllProduct(){
        return productService.listAll();
    }

    @GetMapping(value = "/listPageable")
    public List<Product> listAllProductByCategory(@RequestParam Category category){
        return productService.listAllProductByCategory(category.getId());
    }
    @GetMapping(value = "/checkStock")
    public void checkStock(){
        productService.checkStock();
    }
}
