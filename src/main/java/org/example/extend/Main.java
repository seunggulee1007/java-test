package org.example.extend;

import org.example.IdGenerator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        //[1,5][8,10] 6
        //[1,2][3,4] 2
        //[1,10], [2,8],[3,5] 9
        //[200,300],[100,200] 200
        String date = "20240709";
        String replacedDate = date.replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1-$2-$3");
        System.err.println("replacedDate = " + replacedDate);

        System.err.println(solution(new int[][]{{1,4},{3,5},{8,10}}));
        System.err.println(solution(new int[][]{{1,2},{3,4}}));
        System.err.println(solution(new int[][]{{1,10},{2,8},{3,5}}));
        System.err.println(solution(new int[][]{{200,300},{100,200}}));

        System.err.println(IdGenerator.generate());

        System.err.println(2024 % 2);

    }

    public static int solution(int[][] customer) {
        Arrays.sort(customer, Comparator.comparingInt(a -> a[0]));
        int max = Integer.MIN_VALUE;
        for (int[] cus : customer) {
            max = Math.max(max, cus[1]);
        }
        boolean[] memorize = new boolean[max+1];
        int count = 0;
        for (int[] cus : customer) {
            if(!memorize[cus[0]]) count++;
            for(int i= cus[0]; i<= cus[1]; i++) {
                memorize[i] = true;
            }
        }

        int total = 0;
        for (boolean memory : memorize) {
            if(memory) total++;
        }
        return total - count;
    }

    long add(int a, int b){return a+b;}
    int add(long a, int b){return (int)( a+b);}
    long add(long a, long b){return a+b;}
    int add(byte a, byte b){return a+b;}
}
