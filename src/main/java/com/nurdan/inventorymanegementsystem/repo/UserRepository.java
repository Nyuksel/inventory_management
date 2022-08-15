package com.nurdan.inventorymanegementsystem.repo;

import com.nurdan.inventorymanegementsystem.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    @Query(value = "select * from user_table as ut where ut.user_role is not null", nativeQuery = true)
    List<User> findAllUserByNotNullUserRole();
}
