package com.prv.example.demoSB.services;

import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.repositories.FruitRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FruitService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FruitRepository fruitRepository;

    public Optional<Fruit> findById(final Long id) {

        return this.fruitRepository.findById(id);
    }

    public Fruit getMeAnOrange() {
        return this.fruitRepository.getAnOrange();
    }

    @Transactional
    public Fruit addNewFruit(final String name) {
        final Fruit fruit = new Fruit();
        fruit.setName(name);

        return this.fruitRepository.saveAndFlush(fruit);
    }

    @Transactional
    public void deleteFruitById(final Long id) throws NullPointerException {
        final Optional<Fruit> fruitToDelete = this.fruitRepository.findById(id);
        fruitToDelete.ifPresent(fruit -> this.fruitRepository.delete(fruit));
    }

    @Transactional
    public Optional<Fruit> updateFruitById(final Long id, final String name) {
        final Optional<Fruit> fruitToUpdate = this.fruitRepository.findById(id);
        fruitToUpdate.ifPresent(fruit -> {
            fruit.setName(name);
            this.fruitRepository.saveAndFlush(fruit);
        });
        return fruitToUpdate;
    }

    @Transactional
    public Fruit updateFruitByName(final String oldName, final String newName) {
        final Fruit fruit = new Fruit();
        fruit.setName(oldName);
        final Fruit fruitToUpdate = entityManager.find(Fruit.class, fruit);
        if(fruitToUpdate != null) {
            fruit.setName(newName);
            return this.fruitRepository.saveAndFlush(fruit);
        }
        return null;
    }

}
