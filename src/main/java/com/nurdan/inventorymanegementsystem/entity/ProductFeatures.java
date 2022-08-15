package com.nurdan.inventorymanegementsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_features")
@Data
public class ProductFeatures implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String featuresName;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
