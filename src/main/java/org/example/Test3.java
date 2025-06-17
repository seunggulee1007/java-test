package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2751. 수 정렬하기 2 * * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 */
public class Test3 {

    // [0,1,0,1,];
    public static int[] array = new int[1000001]; // 1,2,3,4,5

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            array[Integer.parseInt(br.readLine())] = 1;
        }
        for (int i = 0; i < 1000000; i++) {
            if (array[i] == 1) {
                System.out.println(i);
            }
        }
    }

}
