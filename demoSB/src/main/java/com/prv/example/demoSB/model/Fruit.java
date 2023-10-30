package com.prv.example.demoSB.model;


import jakarta.persistence.*;

@Entity
@Table(name = "fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FRUIT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Fruit(final Long id) {
        this.id = id;
    }

    public Fruit() {}

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }


}
