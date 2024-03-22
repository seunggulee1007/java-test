package org.example.animal;

public class Tiger implements Animal{

    private final String name;

    public Tiger(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
