package com.nurdan.inventorymanegementsystem.controller;

import com.nurdan.inventorymanegementsystem.dto.ProductOperationsDto;
import com.nurdan.inventorymanegementsystem.entity.Product;
import com.nurdan.inventorymanegementsystem.entity.ProductOperations;
import com.nurdan.inventorymanegementsystem.service.ProductOperationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/productOperation")
@RequiredArgsConstructor
public class ProductOperationsController {
    private final ProductOperationsService productOperationsService;

    @PostMapping(value = "/add")
    public ResponseEntity<Product> addProduct(@Validated @RequestBody ProductOperationsDto dto){
        return ResponseEntity.ok(productOperationsService.addProduct(dto));
    }

    @PostMapping(value = "/subtract")
    public Product subtractProduct(@Validated @RequestBody ProductOperationsDto dto){
        return productOperationsService.subtractProduct(dto);
    }

    @GetMapping(value = "/listAll")
    public List<ProductOperations> listAllProductByOperations(@RequestParam Long id){
        return productOperationsService.listAllProduct(id);
    }
}