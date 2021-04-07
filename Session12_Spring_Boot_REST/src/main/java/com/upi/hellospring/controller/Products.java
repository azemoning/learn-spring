package com.upi.hellospring.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api", produces = "application/json")
public class Products {

    ArrayList<String> product = new ArrayList<>();

    @GetMapping("/product")
    public Map<String, Object> getProducts() {
        Map<String, Object> map = new HashMap<>();
        map.put("products", product);
        return map;
    }

    @PostMapping("/product")
    @ResponseBody
    public String createProduct(@RequestBody String name) {
        product.add(name);
        return name;
    }

    @PutMapping("/product/{id}")
    @ResponseBody
    public String updateProduct(@PathVariable Integer id, @RequestBody String name) {
        product.set(id, name);
        return name;
    }

    @DeleteMapping("/product/{id}")
    public Map<String, Object> deleteProduct(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        product.remove(id);
        map.put("deleted", id);
        return map;
    }
}
