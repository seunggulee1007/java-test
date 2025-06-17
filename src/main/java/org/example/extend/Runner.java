package org.example.extend;

class Super {

    int index = 5;
    public void printVal() {
        System.out.println("Super");
    }
}

class Sub extends Super{
    int index = 2;
    public void printVal() {
        System.out.println("Sub");
    }
}

public class Runner {

    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.index);
        sub.printVal();
    }
}
