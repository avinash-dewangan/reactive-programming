package com.avi.reactive_programming.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    public Flux<Map<String, Object>> getAllProducts() {
        List<Map<String, Object>> productList = List.of(
                Map.of("id", "1", "name", "Laptop", "price", 1200),
                Map.of("id", "2", "name", "Smartphone", "price", 800),
                Map.of("id", "3", "name", "Tablet", "price", 500)
        );

        return Flux.fromIterable(productList);
    }

    public Mono<String> getProductById(String id) {
        return Mono.just("Laptop - ID: " + id);
    }
}

