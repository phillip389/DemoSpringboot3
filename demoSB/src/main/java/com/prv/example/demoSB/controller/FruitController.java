package com.prv.example.demoSB.controller;

import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("fruit")
public class FruitController {

    @Autowired
    private FruitService service;

    @GetMapping("/")
    public String getHelloWorld() {

        return "Hello there, mate!";
    }

    @GetMapping("/all")
    public List<Fruit> getAllFruits() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Optional<Fruit> getFruit(@PathVariable("id") Long id) {

        return this.service.findById(id);
    }

    @GetMapping("/orange")
    public Fruit getOrange() {
        return this.service.getMeAnOrange();
    }

    @PostMapping("/update/{id}")
    public Optional<Fruit> renameFruit(@PathVariable("id") final Long id, final String newName) {
        return this.service.updateFruitById(id, newName);
    }

    @PutMapping("/add")
    public Fruit addNewFruit(final String fruitName) {
        return this.service.addNewFruit(fruitName);
    }

    @DeleteMapping("delete/id/{id}")
    public void deleteFruit(@PathVariable("id") final Long id) {
        this.service.deleteFruitById(id);
    }

}
