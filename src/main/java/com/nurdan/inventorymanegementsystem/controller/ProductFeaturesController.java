package com.nurdan.inventorymanegementsystem.controller;

import com.nurdan.inventorymanegementsystem.dto.ProductFeaturesDto;
import com.nurdan.inventorymanegementsystem.entity.ProductFeatures;
import com.nurdan.inventorymanegementsystem.service.ProductFeaturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/productFeature")
@RequiredArgsConstructor
public class ProductFeaturesController {
    public final ProductFeaturesService productFeaturesService;

    @PostMapping(value = "/add")
    public ResponseEntity<ProductFeatures> addProductFeature(@Validated @RequestBody ProductFeaturesDto dto){
        return ResponseEntity.ok(productFeaturesService.addProductFeatures(dto));
    }

    @PostMapping(value = "/delete")
    public Boolean deleteProductFeature(@RequestParam Long id){
        return productFeaturesService.deleteProductFeatures(id);
    }

    @GetMapping(value = "/listAllProduct")
    public List<ProductFeatures> listAllProductByOperations(@RequestParam Long id){
        return productFeaturesService.listAllByProduct(id);
    }
}