package com.example.beadando.Service;

import com.example.beadando.Entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAllProducts();

    ProductEntity saveProduct(ProductEntity product);

    ProductEntity getProductById(Long id);

    ProductEntity updateProduct(ProductEntity product);

    void deleteProductById(Long id);
}
