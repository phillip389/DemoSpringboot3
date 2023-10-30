package com.prv.example.demoSB.repositories;

import com.prv.example.demoSB.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

    @Query("select s from Superhero s where s.name = ?1 or s.power = ?2")
    List<Superhero> findByNameOrPower(final String name, final String power);
}
