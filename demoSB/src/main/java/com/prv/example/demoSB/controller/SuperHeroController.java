package com.prv.example.demoSB.controller;

import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.model.Hero;
import com.prv.example.demoSB.model.Superhero;
import com.prv.example.demoSB.services.FruitService;
import com.prv.example.demoSB.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("hero")
public class SuperHeroController {

    @Autowired
    private SuperheroService service;

    @GetMapping("/")
    public String getHelloWorld() {

        return "Hello there, Big Hero 6!";
    }

    @GetMapping("/{id}")
    public Optional<Superhero> getFruit(@PathVariable("id") Long id) {

        return this.service.findById(id);
    }

    @GetMapping("/findOne")
    public Optional<Superhero> getAHero() {
        return this.service.getMeAHero();
    }

    @PutMapping("/add")
    public Superhero addNewHero(final Hero hero) {
        return this.service.addNewHero(hero);
    }

}
