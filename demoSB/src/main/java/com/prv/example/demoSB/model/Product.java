package com.prv.example.demoSB.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "product")
@SecondaryTable(name = "FRUIT", foreignKey = @ForeignKey(name = "FRUIT_ID", foreignKeyDefinition = "FRUIT_ID"))
@SecondaryTable(name = "SUPERHERO", foreignKey = @ForeignKey(name = "HERO_ID", foreignKeyDefinition = "HERO_ID"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FRUIT_ID", referencedColumnName = "FRUIT_ID", insertable=false, updatable=false)
    public Fruit fruit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HERO_ID", referencedColumnName = "HERO_ID", insertable=false, updatable=false)
    public Superhero hero;

    public Product() {}


    @Transient
    @Column(name = "FRUIT_ID")
    private Long fruitId;

    @Transient
    @Column(name = "HERO_ID")
    private Long heroId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(final Fruit fruit) {
        this.fruit = fruit;
    }

    public Superhero getHero() {
        return hero;
    }

    public void setHero(final Superhero hero) {
        this.hero = hero;
    }

    public Long getFruitId() {
        return fruitId;
    }

    public void setFruitId(final Long fruitId) {
        this.fruitId = fruitId;
    }

    public Long getHeroId() {
        return heroId;
    }

    public void setHeroId(final Long heroId) {
        this.heroId = heroId;
    }
}
