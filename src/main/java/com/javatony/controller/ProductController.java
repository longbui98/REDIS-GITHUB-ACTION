package com.javatony.controller;

import com.javatony.config.RedisMessagePublisher;
import com.javatony.enity.Product;
import com.javatony.model.Message;
import com.javatony.repository.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductDao productDao;
    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

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

    @PostMapping("/publish")
    private void publish(@RequestBody Message message) {
        logger.info("==== Publish message ====: " + message);
        redisMessagePublisher.publish(message.toString());
    }
}
