package com.prv.example.demoSB.services;

import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.model.Hero;
import com.prv.example.demoSB.model.Product;
import com.prv.example.demoSB.model.Superhero;
import com.prv.example.demoSB.repositories.FruitRepository;
import com.prv.example.demoSB.repositories.ProductRepository;
import com.prv.example.demoSB.repositories.SuperheroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FruitRepository fruitRepository;

    @Autowired
    private SuperheroRepository superheroRepository;

    public Optional<Product> findProductById(final Long id) {
        return this.productRepository.findById(id);
    }

    @Transactional
    public List<Product> loadAllProducts() {
        return new ArrayList<>(this.productRepository.findAll());
    }

    @Transactional
    public Product createProduct(final Long fruitId, final Long heroId) {
        final Product product = new Product();
        product.setHeroId(heroId);
        product.setFruitId(fruitId);

        return this.productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(final Product product, final Long fruitId, final Long heroId) {
        product.setFruitId(fruitId);
        product.setHeroId(heroId);
        return this.productRepository.save(product);
    }
}
