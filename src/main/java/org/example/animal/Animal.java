package org.example.animal;

public interface Animal {


    default void eat() {
        System.out.println(getName() + "이(가) 먹기 시작합니다.");
    }

    default void drink() {
        System.out.println(getName() + "이(가) 마시기 시작합니다.");
    }

    String getName();

}
