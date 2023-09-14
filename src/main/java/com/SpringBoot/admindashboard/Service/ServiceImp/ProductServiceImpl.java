package com.SpringBoot.admindashboard.Service.ServiceImp;

import com.SpringBoot.admindashboard.Entities.ProductEntity;
import com.SpringBoot.admindashboard.Repository.ProductRepository;
import com.SpringBoot.admindashboard.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public String createNewProduct(ProductEntity product)
    {
        repository.save(product);
        return ("Product successfully saved");
    }
    @Override
    public ProductEntity getProductById(Long id) {
        Optional<ProductEntity> productEntity = repository.findById(id);
        return productEntity.orElse((null));
    }

    @Override
    public List<ProductEntity> getAllProducts()
    {
       return (repository.findAll());
    }
    @Override
    public String deleteProduct(Long id) {
        repository.deleteById(id);
        return ("Product successfully deleted!");
    }

    @Override
    public void updateProduct(ProductEntity product) {

    }
}
