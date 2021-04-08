package com.upi.hellospring.controller;

import com.upi.hellospring.exception.ResourceNotFoundException;
import com.upi.hellospring.model.Product;
import com.upi.hellospring.repository.ProductRepository;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("products")
    public ResponseEntity<Object> getProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        Product findProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return new ResponseEntity<>(findProduct, HttpStatus.OK);
    }

    @PostMapping("products")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product findProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        findProduct.setNama(product.getNama());
        findProduct.setQty(product.getQty());
        findProduct.setHarga(product.getHarga());

        productRepository.save(findProduct);
        return new ResponseEntity<>(findProduct, HttpStatus.OK);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        Product findProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(findProduct);
        return new ResponseEntity<>(findProduct, HttpStatus.OK);
    }
}
