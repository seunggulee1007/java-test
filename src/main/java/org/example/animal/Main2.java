package org.example.animal;

import jakarta.json.*;

import java.io.StringReader;
import java.io.StringWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Long a = Long.valueOf("1");
        Long b = 1L;
        Long c = 1L;

        System.err.println(a==b);
        System.err.println(a.hashCode());
        System.err.println(b.hashCode());
        System.err.println(c.hashCode());
        String str = "abcdefgh";

        System.err.println(1 % 500 == 0);
        System.err.println(501 % 500 == 0);
        System.err.println(1500 % 500 == 0);
        // 정규 표현식을 사용하여 2글자씩 분리
        String[] parts = parse(str, 4);

        // 결과 출력
        System.out.println(Arrays.toString(parts));
        String command = "";
        List<String> strings = Arrays.asList(command.split(" ")).subList(0, 1);
        System.err.println(strings);

        // 기존 JSON 문서 (기본 데이터)
        String originalJson = "{\"name\":\"Alice\",\"age\":25,\"city\":\"New York\"}";

        // Merge Patch 문서 (수정할 데이터)
        String patchJson = "{\"age\":26,\"city\":null}";

        // 기존 JSON 읽기
        try(
            JsonReader originalReader = Json.createReader(new StringReader(originalJson));
            JsonReader patchReader = Json.createReader(new StringReader(patchJson))
        ) {

            JsonStructure original = originalReader.read();

            JsonStructure patchStructure = patchReader.read();

            // JSON Merge Patch 생성
            JsonMergePatch patch = Json.createMergePatch(patchStructure);

            // Merge Patch 적용 (기존 JSON에 Patch를 적용)
            JsonValue merged = patch.apply(original);
            System.out.println("Merged JSON: " + merged);
        }

        String abc = "abc";
        String[] split = abc.split(",");
        System.err.println(split.length);
        System.err.println(split[0]);

        String empIds = "/7931/3301683/11573//13717";
        StringTokenizer st = new StringTokenizer(empIds, "/");
        st.countTokens();
        List<String> empIdArray = new ArrayList<>();
        while (st.hasMoreTokens()) {
            empIdArray.add(st.nextToken());
        }

        ABC abc1 = new ABC();
        abc1.age = 1;
        abc1.city = "seoul";
        List<ABC> abcList = new ArrayList<>();
        abcList.add(abc1);
        List<String> list = abcList.stream().filter(e -> e.name != null).toList().stream().map(e -> e.name).toList();
        System.err.println(list.size());
        for (String s : list) {
            System.err.println(s);
        }

        System.err.println(empIdArray);
        Collections.reverse(empIdArray);
        System.err.println(empIdArray);

        String camelCase = "fixedIncenMon1hlf";
        String snakeCase = toSnakeCase(camelCase);
        System.out.println(snakeCase); // fixed_incen_mon_1hlf
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        for(int i=0; i<5; i++) {
            random(integers);
        }

        LocalDate firstDate = LocalDate.of(2024, 1, 1);
        LocalDate parse = LocalDate.parse("2024-12-01");
        System.err.println(firstDate);
        System.err.println(parse);

        Period between = Period.between(parse, firstDate);
        long days = between.getDays();
        System.err.println(days);
        System.err.println(between.getMonths());
        System.err.println(ChronoUnit.DAYS.between(firstDate, parse));

        Test a1 = Test.valueOf("A");
        System.err.println(a1.name());
        Integer a2222 = null;
        int bbb = a2222;
        System.err.println(bbb);
    }

    private static void random(List<Integer> integers) {
        Random rnd = new Random(1);
        for(int i=0; i< 10; i++) {
            Collections.shuffle(integers, rnd);
            System.err.println(integers);
        }
        System.err.println();
    }

    static class ABC {
        private String name;
        private int age;
        private String city;

        @Override public String toString() {
            return "ABC{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
        }

    }
    public static String[] parse(String str, int groupSize) {
        if(str.length() % groupSize != 0) {
            throw new RuntimeException("Invalid group size");
        }
        return str.split("(?<=\\G.{" + groupSize + "})");
    }

    public static String toSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2") // 대문자 앞에 언더스코어
            .replaceAll("([a-zA-Z])([0-9])", "$1_$2") // 숫자 앞에 언더스코어
            .toLowerCase(); // 모두 소문자로 변환
    }

    public enum Test {
        A, B, C
    }

}
