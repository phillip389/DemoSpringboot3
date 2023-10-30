package com.prv.example.demoSB.converter;

import com.prv.example.demoSB.model.Hero;
import com.prv.example.demoSB.model.Superhero;
import org.springframework.stereotype.Controller;

@Controller
public class SuperheroConverter {

    public Superhero convertHero(final Hero hero) throws NullPointerException {
        final Superhero newHero = new Superhero();
        newHero.setName(hero.getName());
        newHero.setPower(hero.getPower());
        return newHero;
    }

}
