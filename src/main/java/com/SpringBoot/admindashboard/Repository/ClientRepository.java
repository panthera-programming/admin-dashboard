package com.SpringBoot.admindashboard.Repository;

import com.SpringBoot.admindashboard.Entities.ClientEntity;
import com.SpringBoot.admindashboard.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByEmail(String email);
    List<ClientEntity> findByProduct(ProductEntity product);

    @Query(
            value = "SELECT * FROM clients_table s WHERE s.product_id = ?1",
            nativeQuery = true
    )
    List<ClientEntity> findAllByProduct(Long prodId);
}
