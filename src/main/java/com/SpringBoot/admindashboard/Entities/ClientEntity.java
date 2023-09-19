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
@Table(name = "clients_table")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    @Column(name = "client_name", length = 100)
    private String name;
    @Column(name = "client_email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "client_phone", nullable = false, unique = true)
    private Long phone;
    @ManyToMany
    @JoinTable(
            name = "clients_products_table",
            joinColumns = {
                    @JoinColumn(name = "client_id", referencedColumnName = "client_id"),
                    @JoinColumn(name = "client_name", referencedColumnName = "client_name"),
                    @JoinColumn(name = "client_email", referencedColumnName = "client_email"),
                    @JoinColumn(name = "client_phone", referencedColumnName = "client_phone")
            },
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    )
    private Set<ProductEntity> product;
}
