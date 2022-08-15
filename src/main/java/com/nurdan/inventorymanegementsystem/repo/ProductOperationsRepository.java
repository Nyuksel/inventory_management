package com.nurdan.inventorymanegementsystem.repo;

import com.nurdan.inventorymanegementsystem.entity.ProductOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductOperationsRepository extends JpaRepository<ProductOperations,Long> {
    List<ProductOperations> findAllByProductId (Long id);
}
