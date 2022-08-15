package com.nurdan.inventorymanegementsystem.controller;

import com.nurdan.inventorymanegementsystem.dto.UserDto;
import com.nurdan.inventorymanegementsystem.entity.User;
import com.nurdan.inventorymanegementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping(value = "/save")
    public ResponseEntity<User> save(@Validated @RequestBody UserDto dto){
        return ResponseEntity.ok(userService.saveUser(dto));
    }

    @PostMapping(value = "/update")
    public ResponseEntity<User> update(@Validated @RequestBody UserDto dto){
        return ResponseEntity.ok(userService.updateUser(dto));
    }

    @GetMapping(value = "/delete")
    public Boolean delete(@RequestParam Long id){
        return userService.deleteUser(id);
    }

    @GetMapping(value = "/listAll")
    public List<User> listAll(){
        return userService.listAllUser();
    }

    @PostMapping(value = "/listPageable")
    public Page<User> listPageable(@RequestBody Pageable pageable){
        return userService.listPageable(pageable);
    }
}