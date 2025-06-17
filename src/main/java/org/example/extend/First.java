package org.example.extend;

final class First {

    public int x = 0;
    public static void main(String[] args) {
        int[]x = {0,'0','A','a'};
        System.out.println(add(x));
    }
    public static int add(int arr[]) {
        int x = -1;
        for (int j : arr) {
            x = Math.max(x, j);
            System.out.println(x);
        }
        return x;
    }

    protected class Test{

    }
}

