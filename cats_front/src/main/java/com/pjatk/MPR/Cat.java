package com.pjatk.MPR;



public class Cat {
    int id;
    String name;
    String race;
    public Cat (int id, String name, String race) {
        this.id = id;
        this.name = name;
        this.race = race;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race){this.race = race;}

    public String getRace(){return race;}

    public Cat() {}
}
