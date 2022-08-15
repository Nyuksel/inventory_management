package com.nurdan.inventorymanegementsystem.service;

import com.nurdan.inventorymanegementsystem.dto.ProductDto;
import com.nurdan.inventorymanegementsystem.entity.Product;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductService {
    @Transactional
    Product saveProduct (ProductDto dto);
    Product updateProductCategory (ProductDto dto);
    @Transactional
    Boolean deleteProduct (Long id);
    List<Product> listAll ();
    List<Product> listAllProductByCategory (Long categoryId);
    void checkStock ();
}