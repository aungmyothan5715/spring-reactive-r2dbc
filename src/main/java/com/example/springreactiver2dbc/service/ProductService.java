package com.example.springreactiver2dbc.service;

import com.example.springreactiver2dbc.model.Product;
import com.example.springreactiver2dbc.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Data carry object -> one is Flux, Flux is many form and next is Mono, Mono is only one Form.
    public Flux<Product> getProducts(){
        return productRepository.findAll()
                .delayElements(Duration.ofSeconds(5));
    }
}
