package com.prv.example.demoSB.repositories;

import com.prv.example.demoSB.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    @Query("SELECT f from Fruit f where f.name = 'Orange'")
    public Fruit getAnOrange();

}
