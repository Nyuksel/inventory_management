package com.nurdan.inventorymanegementsystem.service;

import com.nurdan.inventorymanegementsystem.dto.UserDto;
import com.nurdan.inventorymanegementsystem.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    @Transactional
    User  saveUser (UserDto dto);
    User updateUser (UserDto dto);
    @Transactional
    Boolean deleteUser (Long id);
    List<User> listAllUser ();
    Page<User> listPageable (Pageable pageable);
}
