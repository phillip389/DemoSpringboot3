package com.prv.example.demoSB.repositories;

import com.prv.example.demoSB.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
