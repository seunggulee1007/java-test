package org.example;

import org.example.animal.Animal;
import org.example.animal.JdkProxyTest;
import org.example.animal.Rabbit;
import org.example.animal.Tiger;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

class JdkProxyTestTest {

    @Test
    void test() {
        Animal rabbit =
            (Animal)Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[] {Animal.class}, new JdkProxyTest(new Rabbit("토끼")));
        Animal tiger =
            (Animal)Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[] {Animal.class}, new JdkProxyTest(new Tiger("호랑이")));

        rabbit.eat();
        tiger.eat();
        rabbit.drink();
        tiger.drink();
    }
}