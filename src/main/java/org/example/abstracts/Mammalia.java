package org.example.abstracts;

public abstract class Mammalia implements Animal {

    abstract void giveBirth();

    void attack() {
        System.out.println(this.getClass().getName()  + "(이)가 공격을 진행합니다.");
    }

}
