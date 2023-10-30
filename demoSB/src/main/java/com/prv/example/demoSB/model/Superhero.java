package com.prv.example.demoSB.model;


import jakarta.persistence.*;

@Entity
@Table(name = "superhero")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HERO_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "POWER")
    private String power;

    public Superhero(final Long id) {
        this.id = id;
    }

    public Superhero() {}


    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
