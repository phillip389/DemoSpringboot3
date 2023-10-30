package com.prv.example.demoSB.controller;


import com.prv.example.demoSB.model.Product;
import com.prv.example.demoSB.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") final Long id) {

        return this.service.findProductById(id);
    }

    @PostMapping("/{id}")
    public Product updateProductById(@PathVariable("id") final Long id, final Long fruitId, final Long heroId) {
        final Product product = this.getProductById(id).orElse(null);
        return this.service.updateProduct(product, fruitId, heroId);
    }

    @PutMapping("/add")
    public Product addNewProduct(final Long fruitId, final Long heroId) {
        return this.service.createProduct(fruitId, heroId);
    }

    @GetMapping("list")
    public List<Product> getProducts() {
        return this.service.loadAllProducts();
    }
}
