package com.example.app.Service;

import com.example.app.Models.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long productId);
    Product updateProduct(Long productId, Product updatedProduct);
    void deleteProduct(Long productId);
}
