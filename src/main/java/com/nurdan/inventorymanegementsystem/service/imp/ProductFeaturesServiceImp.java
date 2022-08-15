package com.nurdan.inventorymanegementsystem.service.imp;

import com.nurdan.inventorymanegementsystem.dto.ProductFeaturesDto;
import com.nurdan.inventorymanegementsystem.entity.ProductFeatures;
import com.nurdan.inventorymanegementsystem.repo.ProductFeaturesRepository;
import com.nurdan.inventorymanegementsystem.service.ProductFeaturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFeaturesServiceImp implements ProductFeaturesService {
    public final ProductFeaturesRepository productFeaturesRepository;
    @Transactional
    public ProductFeatures addProductFeatures(ProductFeaturesDto dto) {
        ProductFeatures productFeatures = new ProductFeatures();
        productFeatures.setFeaturesName(dto.getFeaturesName());
        productFeatures.setProduct(dto.getProduct());
        return productFeatures;
    }
    @Override
    @Transactional
    public Boolean deleteProductFeatures(Long id) {
        ProductFeatures productFeatures = productFeaturesRepository.getById(id);
        if(productFeatures != null){
            productFeaturesRepository.delete(productFeatures);
            return true;
        }
        return false;
    }
    @Override
    public List<ProductFeatures> listAllByProduct(Long id) {
        List<ProductFeatures> list = productFeaturesRepository.findAllByProductId(id);
        return list;
    }
}