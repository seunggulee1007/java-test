package org.example.animal;

import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CGLibHandlerTest {

    @Test
    void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(new CGLibHandler());
        Dog dog = (Dog)enhancer.create();
        dog.eat();
        dog.drink();
    }

}