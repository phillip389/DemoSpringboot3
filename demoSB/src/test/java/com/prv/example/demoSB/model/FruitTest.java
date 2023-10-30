package com.prv.example.demoSB.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {

    private Fruit mockFruit = null;

    @BeforeEach
    void setup() {
        mockFruit = new Fruit();
    }

    @Test
    void test_setId() {
        this.mockFruit.setId(111L);
        assertEquals(111L, this.mockFruit.getId());
        assertNull(this.mockFruit.getName());
    }

    @Test
    void test_setName() {
        this.mockFruit.setName("Banana");
        assertNull(this.mockFruit.getId());
        assertEquals("Banana", this.mockFruit.getName());
    }


}