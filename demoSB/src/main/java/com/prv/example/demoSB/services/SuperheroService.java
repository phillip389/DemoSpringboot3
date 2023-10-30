package com.prv.example.demoSB.services;

import com.prv.example.demoSB.converter.SuperheroConverter;
import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.model.Hero;
import com.prv.example.demoSB.model.Superhero;
import com.prv.example.demoSB.repositories.FruitRepository;
import com.prv.example.demoSB.repositories.SuperheroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class SuperheroService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SuperheroRepository heroRepository;

    @Autowired
    private SuperheroConverter converter;

    public Optional<Superhero> findById(final Long id) {

        return this.heroRepository.findById(id);
    }

    ///public Superhero getMeAnHero() {
       // return this.heroRepository.getMeAHero();
    //}

    public Superhero addNewHero(final Hero hero) {
        final Superhero heroToSave = this.converter.convertHero(hero);

        return this.heroRepository.saveAndFlush(heroToSave);
    }

    public Optional<Superhero> getMeAHero() {
        final Random random = new Random();
        final List<Superhero> list = this.heroRepository.findAll();
        return list.stream().skip(random.nextInt(list.size())).findFirst();
    }


}
