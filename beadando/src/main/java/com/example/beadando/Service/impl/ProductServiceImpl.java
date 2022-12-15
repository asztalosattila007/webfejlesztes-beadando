package com.example.beadando.Service.impl;

import com.example.beadando.Entity.ProductEntity;
import com.example.beadando.Repository.ProductRepository;
import com.example.beadando.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
