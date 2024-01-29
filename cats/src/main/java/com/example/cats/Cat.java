package com.example.cats;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String race;

    private String name;

    public Cat(){}

    public Cat(long id, String race, String name){
        this.id=id;
        this.race=race;
        this.name=name;
    }


    public long getId() {
        return id;
    }

    public String getRace() {
        return race;
    }

    public String getName() {
        return name;
    }
    
}
