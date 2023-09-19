package com.SpringBoot.admindashboard.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products_table")
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
    private Set<ClientEntity> client;
}
