package com.nurdan.inventorymanegementsystem.service;

import com.nurdan.inventorymanegementsystem.dto.ProductOperationsDto;
import com.nurdan.inventorymanegementsystem.entity.Product;
import com.nurdan.inventorymanegementsystem.entity.ProductOperations;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductOperationsService {
    @Transactional
    Product addProduct(ProductOperationsDto dto);
    @Transactional
    Product subtractProduct(ProductOperationsDto dto);
    List<ProductOperations> listAllProduct (Long id);
}
