package dev.azemoning.starter.service;

import dev.azemoning.starter.exception.ResourceNotFoundException;
import dev.azemoning.starter.model.Product;
import dev.azemoning.starter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product findProductById = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        findProductById.setName(product.getName());
        findProductById.setQuantity(product.getQuantity());
        return productRepository.save(findProductById);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product findProductById = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        productRepository.delete(findProductById);
        return findProductById;
    }
}
