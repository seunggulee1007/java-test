package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String args[]) throws Exception {

        LocalDate now = LocalDate.now();
        System.out.println(now.lengthOfMonth());
        String ssss = "1234";
        System.out.println(ssss.substring(2, 4));
        // 지역에 따라 화폐 단위를 치환해 주는 formatter java 12 부터 나옴.
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(
            Locale.US, NumberFormat.Style.LONG);

        System.out.println(formatter.format(1000));
        System.out.println(formatter.format(1000000));

        formatter = NumberFormat.getCompactNumberInstance(
            Locale.KOREA, NumberFormat.Style.SHORT);

        System.out.println(formatter.format(1000));
        System.out.println(formatter.format(1000000));

        Double aDouble = Stream.of(1, 2, 3, 4, 5, 6, 7)
            .collect(Collectors.teeing(
                Collectors.summingDouble(i -> i), Collectors.counting(),
                (sum, n) -> sum / n));
        System.out.println(aDouble);

        String test = "123";
        String format = String.format("%5s", "123");
        System.err.println(format);
        long a = 1000;
        System.out.println(Math.round((double)a/11));
        int createYear = LocalDate.now().getYear() + 2;
        System.out.println(createYear);
        int thisYear = LocalDate.now().getYear();
        List<Integer> years = IntStream.rangeClosed(thisYear - 2, thisYear + 2).boxed().collect(Collectors.toList());
        System.out.println(years);
        String test1 = "ddd,dffds,sadf,";
        String[] tests = test1.split(",");
        System.out.println(tests.length);

        LocalDate yyyyMMdd = LocalDate.parse("20240101", DateTimeFormatter.ofPattern("yyyyMMdd"));
        String string = yyyyMMdd.toString().replace("-","");
        System.out.println(string);

        String splitTest = "12345";
        String[] split = splitTest.split(",");
        for (String s : split) {
            System.err.println(s);
        }

        double price = 3300;
        long tax = Math.round(price / 11);
        System.out.println("tax :: " + tax);
    }

}