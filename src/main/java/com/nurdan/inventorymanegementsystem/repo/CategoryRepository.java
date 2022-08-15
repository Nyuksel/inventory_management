package com.nurdan.inventorymanegementsystem.repo;

import com.nurdan.inventorymanegementsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findByUserId (Long id);

    Category findByIdAndUserId (Long id, Long userId);
}