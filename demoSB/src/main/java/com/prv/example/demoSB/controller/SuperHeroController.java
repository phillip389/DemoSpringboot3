package com.prv.example.demoSB.controller;

import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.model.Hero;
import com.prv.example.demoSB.model.Superhero;
import com.prv.example.demoSB.services.FruitService;
import com.prv.example.demoSB.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hero")
public class SuperHeroController {

    @Autowired
    private SuperheroService service;

    @GetMapping("/")
    public List<Superhero> getHelloWorld() {
        return this.service.getAllHeroes();
    }

    @PostMapping("/search")
    public List<Superhero> searchSuperheroes(@RequestBody  final Hero hero) {
        return this.service.searchSuperheroes(hero);
    }

    @GetMapping("/{id}")
    public Optional<Superhero> getFruit(@PathVariable("id") Long id) {

        return this.service.findById(id);
    }

    @GetMapping("/findOne")
    public Optional<Superhero> getAHero() {
        return this.service.getMeAHero();
    }

    @PutMapping("/")
    public Superhero addNewHero(final Hero hero) {
        return this.service.addNewHero(hero);
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable("id") final Long id) {

        this.service.deleteHero(id);

    }

}
