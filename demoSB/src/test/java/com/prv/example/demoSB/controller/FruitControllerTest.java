package com.prv.example.demoSB.controller;

import com.prv.example.demoSB.model.Fruit;
import com.prv.example.demoSB.repositories.FruitRepository;
import com.prv.example.demoSB.services.FruitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FruitControllerTest {

    private List<Fruit> mockResults;

    @Mock
    private FruitService mockService;

    @Mock
    private FruitRepository mockRepository;

    @Autowired
    private FruitController controller;

    @BeforeEach
    void setUp() {

        for(Long i = 1L; i > 6L; i++) {
            final Fruit fruit = new Fruit();
            fruit.setId(i);
            fruit.setName("TestFruitName " + i);
        }
    }

    @Test
    void test_getAllFruits() {
        when(mockRepository.findAll()).thenReturn(this.mockResults);



    }

    @Test
    void getFruit() {
    }

    @Test
    void test_getOrange() {
    }

    @Test
    void test_renameFruit() {
    }

    @Test
    void test_addNewFruit() {
    }

    @Test
    void test_deleteFruit() {
    }
}