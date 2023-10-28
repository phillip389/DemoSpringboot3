package com.prv.example.demoSB.controller;

import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("hero")
public class SuperHeroController {

    @Autowired
    private FruitService service;

    @GetMapping("/")
    public String getHelloWorld() {

        return "Hello there, mate!";
    }

    @GetMapping("/{id}")
    public Optional<Fruit> getFruit(@PathVariable("id") Long id) {

        return this.service.findById(id);
    }

    @GetMapping("/orange")
    public Fruit getOrange() {
        return this.service.getMeAnOrange();
    }

    @PutMapping("/add")
    public Fruit addNewHero(final String fruitName) {
        return this.service.addNewFruit(fruitName);
    }

}
