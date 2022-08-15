package com.nurdan.inventorymanegementsystem.job;

import com.nurdan.inventorymanegementsystem.dto.MailDto;
import com.nurdan.inventorymanegementsystem.entity.Category;
import com.nurdan.inventorymanegementsystem.entity.Product;
import com.nurdan.inventorymanegementsystem.entity.User;
import com.nurdan.inventorymanegementsystem.repo.CategoryRepository;
import com.nurdan.inventorymanegementsystem.repo.ProductRepository;
import com.nurdan.inventorymanegementsystem.repo.UserRepository;
import com.nurdan.inventorymanegementsystem.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationJob {
    public final UserRepository userRepository;
    public final ProductRepository productRepository;
    public final CategoryRepository categoryRepository;
    public final MailService mailService;

    @Async
    @Scheduled(cron = "0 0 0 1/1 * ? *", zone="Europe/Istanbul")
    public void informationJob(){
        List<User> userList = userRepository.findAllUserByNotNullUserRole();
        for (User user: userList) {
            user.setCategories(categoryRepository.findByUserId(user.getId()));
            for (Category category: user.getCategories()){
                List<Product> productList = productRepository.findAllByCategory_Id(category.getId());
                for (Product product: productList) {
                    MailDto mailDto = new MailDto();
                    mailDto.setSend("yönetim");
                    mailDto.setTo(user.getEmail());
                    mailDto.setSubject("Ürün stok bilgisi");
                    mailDto.setDetail(product.getProductName() + " ürünün "+ product.getAmountOfProduct() + " adet stoğu kalmıştır");
                    mailService.sendMail(mailDto);
                }
            }
        }
    }
}
