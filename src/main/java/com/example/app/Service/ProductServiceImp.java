package com.example.app.Service;

import com.example.app.Models.Product;
import com.example.app.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product existingProduct = getProductById(productId);
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductDescription(updatedProduct.getProductDescription());
        existingProduct.setProductCategory(updatedProduct.getProductCategory());
        existingProduct.setProductPrice(updatedProduct.getProductPrice());
        existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
        existingProduct.setExpiryDate(updatedProduct.getExpiryDate());
        existingProduct.setBrand(updatedProduct.getBrand());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
