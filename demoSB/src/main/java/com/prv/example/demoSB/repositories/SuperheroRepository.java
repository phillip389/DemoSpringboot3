package com.prv.example.demoSB.repositories;

import com.prv.example.demoSB.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
}
