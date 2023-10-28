package com.prv.example.demoSB.services;

import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.model.Superhero;
import com.prv.example.demoSB.repositories.FruitRepository;
import com.prv.example.demoSB.repositories.SuperheroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SuperheroService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SuperheroRepository heroRepository;

    public Optional<Superhero> findById(final Long id) {

        return this.heroRepository.findById(id);
    }

    ///public Superhero getMeAnHero() {
       // return this.heroRepository.getMeAHero();
    //}

    public Superhero addNewHero(final String name) {
        final Superhero fruit = new Superhero();
        fruit.setName(name);

        return this.heroRepository.saveAndFlush(fruit);
    }


}
