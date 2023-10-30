package com.prv.example.demoSB.repositories;

import com.prv.example.demoSB.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
