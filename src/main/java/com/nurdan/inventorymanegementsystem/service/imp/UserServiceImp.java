package com.nurdan.inventorymanegementsystem.service.imp;

import com.nurdan.inventorymanegementsystem.dto.MailDto;
import com.nurdan.inventorymanegementsystem.dto.UserDto;
import com.nurdan.inventorymanegementsystem.entity.User;
import com.nurdan.inventorymanegementsystem.repo.UserRepository;
import com.nurdan.inventorymanegementsystem.service.MailService;
import com.nurdan.inventorymanegementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    public final UserRepository userRepository;
    public final MailService mailService;
    @Override
    @Transactional
    public User saveUser(UserDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setUserRole(dto.getUserRole());
        userRepository.save(user);
        MailDto mailDto = new MailDto();
        mailDto.setSend("yonetim");
        mailDto.setTo(dto.getEmail());
        mailDto.setSubject("Bilgilendirme Maili");
        mailDto.setDetail("Sisteme kullanıcı olarak tanımlandınız");
        mailService.sendMail(mailDto);
        return user;
    }
    @Override
    public User updateUser(UserDto dto) {
        User user = userRepository.getById(dto.getId());
        if(user!=null){
        user.setEmail(dto.getEmail());
        user.setUserRole(dto.getUserRole());
        userRepository.save(user);
        }
        return user;
    }
    @Override
    @Transactional
    public Boolean deleteUser(Long id) {
        User user = userRepository.getById(id);
        if(user != null){
           userRepository.delete(user);
           return true;
        }
        return false;
    }
    @Override
    public List<User> listAllUser() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
    @Override
    public Page<User> listPageable(Pageable pageable) {
        Page<User> pageList = userRepository.findAll(pageable);
        return pageList;
    }
}