package com.techbytes.security.api.service;

import com.techbytes.security.api.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {


    private List<Product> products;

    @PostConstruct
    public void loadProducts(){
        products = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Product.builder().id(i).name("product "+i)
                        .qty(new Random().nextInt(10))
                        .price(new Random().nextDouble(5000)).build())
                .collect(Collectors.toList());
    }
    public List<Product> getProducts() {
        return products;
    }



    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId().equals(id))
                .findFirst().orElseThrow(()-> new RuntimeException("Product not found for id : "+id));
    }
}
