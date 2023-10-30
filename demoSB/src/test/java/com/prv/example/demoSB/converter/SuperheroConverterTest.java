package com.prv.example.demoSB.converter;

import com.prv.example.demoSB.model.Hero;
import com.prv.example.demoSB.model.Superhero;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
class SuperheroConverterTest {

    @Autowired
    private SuperheroConverter converter;

    @Test
    void test_convertHeroEmptyHeroReturnsEmptyEntity() {
        final Hero hero = new Hero();
        final Superhero convertedHero = this.converter.convertHero(hero);

        assertNull(convertedHero.getId());
        assertNull(convertedHero.getName());
        assertNull(convertedHero.getPower());

    }

    @Test
    void test_convertHeroNameHeroReturnsHeroEntityWithPowerNoId() {
        final Hero hero = new Hero();
        hero.setPower("TestPower");
        final Superhero convertedHero = this.converter.convertHero(hero);

        assertNull(convertedHero.getId());
        assertNull(convertedHero.getName());
        assertEquals("TestPower", convertedHero.getPower());

    }

    @Test
    void test_convertHeroNameHeroReturnsHeroEntityWithNameNoId() {
        final Hero hero = new Hero();
        hero.setName("TestName");
        final Superhero convertedHero = this.converter.convertHero(hero);

        assertNull(convertedHero.getId());
        assertEquals("TestName", convertedHero.getName());
        assertNull(convertedHero.getPower());

    }

}