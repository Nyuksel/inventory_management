package com.nurdan.inventorymanegementsystem.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_table")
@Data
@ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String userRole;

    @OneToMany
    private List<ProductOperations> productOperations;

    @OneToMany
    private List<Category> categories;

}
