package com.javatony.repository;

import com.javatony.enity.Product;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ProductDao {
    private final String HASH_KEY = "Product";
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProductById(int id) {
        if (Objects.isNull(findProductById(id))) {
            return Strings.EMPTY;
        }
        template.opsForHash().delete(HASH_KEY, id);
        return "Product deleted!";
    }
}
