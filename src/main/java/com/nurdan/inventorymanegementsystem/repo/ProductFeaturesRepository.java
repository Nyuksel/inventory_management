package com.nurdan.inventorymanegementsystem.repo;

import com.nurdan.inventorymanegementsystem.entity.ProductFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductFeaturesRepository extends JpaRepository<ProductFeatures,Long> {

    List<ProductFeatures> findAllByProductId (Long id);
}
