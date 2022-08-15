package com.nurdan.inventorymanegementsystem.service.imp;

import com.nurdan.inventorymanegementsystem.dto.ProductOperationsDto;
import com.nurdan.inventorymanegementsystem.entity.Product;
import com.nurdan.inventorymanegementsystem.entity.ProductOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nurdan.inventorymanegementsystem.repo.ProductOperationsRepository;
import com.nurdan.inventorymanegementsystem.repo.ProductRepository;
import com.nurdan.inventorymanegementsystem.service.ProductOperationsService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOperationsServiceImp implements ProductOperationsService {
    public final ProductOperationsRepository productOperationsRepository;
    public final ProductRepository productRepository;
    @Override
    @Transactional
    public Product addProduct(ProductOperationsDto dto) {
        ProductOperations productOperations = new ProductOperations();
        productOperations.setProduct(dto.getProducts());
        productOperations.setOperationType("ekleme");
        productOperations.setAmountOfOperation(dto.getAmountOfOperation());
        productOperations.setUser(dto.getUsers());
        productOperationsRepository.save(productOperations);
        Product product = productRepository.getById(dto.getProducts().getId());
        product.setAmountOfProduct(product.getAmountOfProduct()+dto.getAmountOfOperation());
        productRepository.save(product);
        return product;
    }
    @Override
    @Transactional
    public Product subtractProduct(ProductOperationsDto dto) {
        ProductOperations productOperations = new ProductOperations();
        productOperations.setProduct(dto.getProducts());
        productOperations.setOperationType("çıkarma");
        productOperations.setAmountOfOperation(dto.getAmountOfOperation());
        productOperations.setUser(dto.getUsers());
        productOperationsRepository.save(productOperations);
        Product product = productRepository.getById(dto.getProducts().getId());
        product.setAmountOfProduct(product.getAmountOfProduct()-dto.getAmountOfOperation());
        productRepository.save(product);
        return product;
    }

    @Override
    public List<ProductOperations> listAllProduct(Long id) {
        List<ProductOperations> list = productOperationsRepository.findAllByProductId(id);
        return list;
    }
}
