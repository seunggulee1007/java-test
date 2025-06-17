package org.example.product;
import java.util.*;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) {
        // 기존 2차원 배열 (사이즈 + 색상)
        List<List<String>> existingOptions = Arrays.asList(
            Arrays.asList("M", "L"),  // X축 (옵션 1: 사이즈)
            Arrays.asList("Red", "Blue")  // Y축 (옵션 2: 색상)
        );

        System.out.println("🔹 기존 조합:");
        printCombinations(generateCombinations(existingOptions));

        // ✅ Y축에 값 추가 (새로운 색상 "Green")
        String newYValue = "Green";
        System.out.println("\n🔹 새로운 색상 추가 후 조합:");
        printCombinations(generateNewCombinationsForY(existingOptions, newYValue));

        // ✅ X축에 새로운 옵션 추가 (재질)
        List<String> newXOption = Arrays.asList("Cotton");
        System.out.println("\n🔹 새로운 옵션 종류 추가 후 조합:");
        printCombinations(generateNewCombinationsForX(existingOptions, newXOption));
        List<Product> lists = new ArrayList<>();
        lists.stream().peek(d -> d.getProductOptions()).sorted(Comparator.comparing(s -> s.getDescription().equals("dd") ? s.getName() : null)).toList();
    }

    // ✅ 기존 2차원 배열 기반으로 모든 조합 생성
    private static List<List<String>> generateCombinations(List<List<String>> options) {
        List<List<String>> result = new ArrayList<>();
        generateCombinationsRecursive(options, 0, new ArrayList<>(), result);
        return result;
    }

    // ✅ 재귀적으로 조합 생성
    private static void generateCombinationsRecursive(List<List<String>> options, int depth, List<String> current, List<List<String>> result) {
        if (depth == options.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (String value : options.get(depth)) {
            current.add(value);
            generateCombinationsRecursive(options, depth + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    // ✅ Y축(기존 옵션)에 새로운 값 추가 시, 새 값에 대한 조합만 생성
    private static List<List<String>> generateNewCombinationsForY(List<List<String>> existingOptions, String newValue) {
        List<List<String>> newCombinations = new ArrayList<>();
        for (String xValue : existingOptions.get(0)) { // X축 값 고정 (사이즈)
            List<String> newCombination = new ArrayList<>();
            newCombination.add(xValue);
            newCombination.add(newValue); // 새 값 추가
            newCombinations.add(newCombination);
        }
        return newCombinations;
    }

    // ✅ X축(새로운 옵션 종류) 추가 시, 새 옵션에 대한 조합만 생성
    private static List<List<String>> generateNewCombinationsForX(List<List<String>> existingOptions, List<String> newOption) {
        List<List<String>> newCombinations = new ArrayList<>();
        List<List<String>> existingCombinations = generateCombinations(existingOptions);

        for (List<String> combination : existingCombinations) {
            for (String newValue : newOption) {
                List<String> newCombination = new ArrayList<>(combination);
                newCombination.add(newValue); // 새로운 옵션 추가
                newCombinations.add(newCombination);
            }
        }
        return newCombinations;
    }

    // ✅ 조합을 출력하는 메서드
    private static void printCombinations(List<List<String>> combinations) {
        for (List<String> combination : combinations) {
            System.out.println(String.join(" + ", combination));
        }
    }


}
