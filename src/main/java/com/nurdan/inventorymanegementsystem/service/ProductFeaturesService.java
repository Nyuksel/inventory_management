package com.nurdan.inventorymanegementsystem.service;

import com.nurdan.inventorymanegementsystem.dto.ProductFeaturesDto;
import com.nurdan.inventorymanegementsystem.entity.ProductFeatures;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductFeaturesService {
    @Transactional
    ProductFeatures addProductFeatures(ProductFeaturesDto dto);
    @Transactional
    Boolean deleteProductFeatures(Long id);
    List<ProductFeatures> listAllByProduct (Long id);
}