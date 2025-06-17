package org.example;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Long generate = IdGenerator.generate();
        System.err.println(generate);
        // 기존 옵션 조합 초기화
        List<List<String>> existingCombinations = generateInitialCombinations();

        System.out.println("🔹 기존 옵션 조합:");
        printCombinations(existingCombinations);

        // 새로운 옵션 추가 (예: 새로운 색상 "Black" 추가)
        String optionType = "Color"; // 추가할 옵션 종류
        List<String> newOptionValues = Arrays.asList("Black"); // 새로운 옵션 값
        List<List<String>> updatedCombinations = addNewOption(existingCombinations, 1, newOptionValues);

        System.out.println("\n🔹 새로운 옵션 추가 후 조합:");
        printCombinations(updatedCombinations);
    }

    // 초기 옵션 조합 생성 (사이즈 + 색상 + 재질)
    private static List<List<String>> generateInitialCombinations() {
        List<List<String>> optionGroups = Arrays.asList(
            Arrays.asList("M", "L", "XL"),  // 사이즈
            Arrays.asList("Red", "Blue", "Green"),  // 색상
            Arrays.asList("Cotton")  // 재질
        );

        return generateCombinationsUsingLoop(optionGroups);
    }

    // 새로운 옵션이 추가되었을 때 기존 조합을 유지하면서 새로운 조합만 추가
    private static List<List<String>> addNewOption(List<List<String>> existingCombinations, int optionIndex, List<String> newValues) {
        List<List<String>> updatedCombinations = new ArrayList<>(existingCombinations);

        // 새로운 옵션 값을 기존 조합의 특정 위치(optionIndex)에 추가
        for (List<String> existingCombination : existingCombinations) {
            for (String newValue : newValues) {
                List<String> newCombination = new ArrayList<>(existingCombination);
                newCombination.set(optionIndex, newValue); // 해당 옵션 위치만 새로운 값으로 변경
                updatedCombinations.add(newCombination);
            }
        }

        return updatedCombinations;
    }

    // 2차원 리스트를 사용하여 모든 옵션 조합을 생성
    private static List<List<String>> generateCombinationsUsingLoop(List<List<String>> optionGroups) {
        List<List<String>> result = new ArrayList<>();
        int totalCombinations = 1;

        for (List<String> group : optionGroups) {
            totalCombinations *= group.size();
        }

        for (int i = 0; i < totalCombinations; i++) {
            List<String> combination = new ArrayList<>();
            int index = i;

            for (List<String> group : optionGroups) {
                int groupSize = group.size();
                combination.add(group.get(index % groupSize));
                index /= groupSize;
            }

            result.add(combination);
        }

        return result;
    }

    // 옵션 조합을 출력하는 메서드
    private static void printCombinations(List<List<String>> combinations) {
        for (List<String> combination : combinations) {
            System.out.println(String.join(" + ", combination));
        }
    }
}
