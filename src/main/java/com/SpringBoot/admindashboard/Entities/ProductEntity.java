package com.SpringBoot.admindashboard.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name", length = 100)
    private String name;
    @Column(name = "product_value")
    private Long value;
    @ManyToMany(mappedBy = "product")
    private ClientEntity client;
}
