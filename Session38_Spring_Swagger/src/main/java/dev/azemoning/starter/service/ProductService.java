package dev.azemoning.starter.service;

import dev.azemoning.starter.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    Product deleteProduct(Long id);
}
