package com.avi.reactive_programming.controller;

import com.avi.reactive_programming.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Map<String, Object>> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<String> getProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }
}
