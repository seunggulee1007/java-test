package org.example.animal;

public class Rabbit implements Animal {

    private final String name;

    public Rabbit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
