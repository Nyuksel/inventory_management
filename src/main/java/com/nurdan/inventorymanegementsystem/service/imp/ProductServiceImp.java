package com.nurdan.inventorymanegementsystem.service.imp;

import com.nurdan.inventorymanegementsystem.dto.MailDto;
import com.nurdan.inventorymanegementsystem.dto.ProductDto;
import com.nurdan.inventorymanegementsystem.entity.Category;
import com.nurdan.inventorymanegementsystem.entity.Product;
import com.nurdan.inventorymanegementsystem.entity.User;
import com.nurdan.inventorymanegementsystem.repo.CategoryRepository;
import com.nurdan.inventorymanegementsystem.repo.ProductRepository;
import com.nurdan.inventorymanegementsystem.repo.UserRepository;
import com.nurdan.inventorymanegementsystem.service.MailService;
import com.nurdan.inventorymanegementsystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    public final ProductRepository productRepository;
    public final CategoryRepository categoryRepository;
    public final UserRepository userRepository;
    public final MailService mailService;
    @Override
    @Transactional
    public Product saveProduct(ProductDto dto){
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setAmountOfProduct(dto.getAmountOfProduct());
        productRepository.save(product);
        return product;
    }
    @Override
    public Product updateProductCategory(ProductDto dto) {
        Product product = productRepository.getById(dto.getId());
        if (product!= null) {
            categoryRepository.findById(dto.getCategoryDto().getId()).ifPresent(category -> {
                Category category1 = categoryRepository.findByIdAndUserId(dto.getCategoryDto().getId(), dto.getCategoryDto().getUser().getId());
                if (category.getUser().equals(category1.getUser())) {
                    product.setCategory(category);
                    productRepository.save(product);
                }
            });
            return product;
        }
        return null;
    }
    @Override
    @Transactional
    public Boolean deleteProduct(Long id) {
        Product product = productRepository.getById(id);
        if(product != null){
            productRepository.delete(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> listAll() {
        List<Product> ProductList = productRepository.findAll();
        return ProductList;
    }

    @Override
    public List<Product> listAllProductByCategory(Long categoryId) {
        List<Product> list = productRepository.findAllByCategory_Id(categoryId);
        return list;
    }

    @Override
    public void checkStock() {
        List<Product> list = productRepository.findAll();
        for (Product entity: list){
            if(entity.getAmountOfProduct() < 100){
                Category category = categoryRepository.getById(entity.getCategory().getId());
                User user = userRepository.getById(category.getUser().getId());
                MailDto mailDto = new MailDto();
                mailDto.setSend("yonetim");
                mailDto.setTo(user.getEmail());
                mailDto.setSubject("Stok Bilgilendirme Maili");
                mailDto.setDetail(entity.getProductName() +" ürünün stoğu 100 adetin altına düşmüştür");
                mailService.sendMail(mailDto);
            }
        }
    }
}
