package org.example.extend;

public class Women extends Person {

    static String name;

    public Women(String name, int age) {
        super(name, age);
    }

    void test() {
        this.getName();
    }

    void setNames(String name1) {
        name = name1;
    }

    String getNames() {
        return name;
    }

}
