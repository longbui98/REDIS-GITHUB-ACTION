package com.javatony.controller;

import com.javatony.enity.Product;
import com.javatony.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @PostMapping
    private Product saveProduct(@RequestBody Product product) {
        return productDao.save(product);
    }

    @GetMapping
    private List<Product> getProducts() {
        return productDao.findAll();
    }

    @GetMapping("/{id}")
    private Product getProductById(@PathVariable int id) {
        return productDao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    private String deleteProductById(@PathVariable int id) {
        return productDao.deleteProductById(id);
    }

}
