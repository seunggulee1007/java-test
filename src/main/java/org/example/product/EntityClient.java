package org.example.product;

import java.util.*;
import java.util.stream.Collectors;

public class EntityClient {

    public static void main(String[] args) {
        // ✅ 1. 상품 생성
        Product product = new Product(1L, "Nike Running Shoes", "Comfortable running shoes");

        // ✅ 2. 옵션 생성 (사이즈, 색상)
        ProductOption sizeOption = new ProductOption(10L,"Size");
        sizeOption.addOptionDetail(new ProductOptionDetail(101L,"M", 10L));
        sizeOption.addOptionDetail(new ProductOptionDetail(102L,"L", 10L));
        sizeOption.addOptionDetail(new ProductOptionDetail(103L,"XL", 10L));

        ProductOption colorOption = new ProductOption(20L,"Color");
        colorOption.addOptionDetail(new ProductOptionDetail(201L,"Red",20L));
        colorOption.addOptionDetail(new ProductOptionDetail(202L,"Blue",20L));

        // 3. 상품에 옵션 추가
        product.addOption(sizeOption);
        product.addOption(colorOption);

        // 4. 기존 조합 생성
        List<List<ProductOptionDetail>> existingCombinations = generateCombinations(product);
        System.out.println("🔹 기존 조합:");
        printCombinations(existingCombinations);

        // 5. 새로운 색상 추가 (Y축 값 추가)

    }

    // 기존 옵션으로 모든 가능한 조합을 생성
    private static List<List<ProductOptionDetail>> generateCombinations(Product product) {
        List<List<ProductOptionDetail>> optionGroups = new ArrayList<>();
        for (ProductOption option : product.getProductOptions()) {
            optionGroups.add(option.getOptionDetails());
        }
        return generateCombinationsUsingLoop(optionGroups);
    }

    // 2차원 리스트 기반 모든 조합 생성
    private static List<List<ProductOptionDetail>> generateCombinationsUsingLoop(List<List<ProductOptionDetail>> optionGroups) {
        List<List<ProductOptionDetail>> result = new ArrayList<>();
        int totalCombinations = 1;

        for (List<ProductOptionDetail> group : optionGroups) {
            totalCombinations *= group.size();
        }

        for (int i = 0; i < totalCombinations; i++) {
            List<ProductOptionDetail> combination = new ArrayList<>();
            int index = i;

            for (List<ProductOptionDetail> group : optionGroups) {
                int groupSize = group.size();
                combination.add(group.get(index % groupSize));
                index /= groupSize;
            }

            result.add(combination);
        }

        return result;
    }

    // Y축(기존 옵션)에 새로운 값 추가 시, 새 값에 대한 조합만 생성 (중복 제거)
    private static List<List<ProductOptionDetail>> addNewValueToExistingCombinations(
        List<List<ProductOptionDetail>> existingCombinations,
        Product product,
        Long optionId, // 옵션 종류 ID (예: "Color" 옵션의 ID)
        List<ProductOptionDetail> newValues) {

        List<List<ProductOptionDetail>> newCombinations = new ArrayList<>();
        int optionIndex = -1;

        // ✅ 옵션 ID를 기반으로 해당 옵션의 위치 찾기
        List<ProductOption> productOptions = product.getProductOptions();
        for (int i = 0; i < productOptions.size(); i++) {
            if (productOptions.get(i).getId().equals(optionId)) {
                optionIndex = i;
                break;
            }
        }

        if (optionIndex == -1) {
            throw new IllegalArgumentException("해당 옵션이 존재하지 않습니다: ID = " + optionId);
        }

        // ✅ 기존 조합에서 새로운 옵션 값이 적용된 조합만 생성
        for (List<ProductOptionDetail> existingCombination : existingCombinations) {
            for (ProductOptionDetail newValue : newValues) {
                List<ProductOptionDetail> newCombination = new ArrayList<>(existingCombination);
                newCombination.set(optionIndex, newValue); // 기존 값 대체
                newCombinations.add(newCombination); // 새로운 조합만 추가
            }
        }

        return newCombinations;
    }

    // X축(새로운 옵션 종류) 추가 시, 새 옵션에 대한 조합만 생성
    // ✅ X축(새로운 옵션 종류) 추가 (ID 기반)
    private static List<List<ProductOptionDetail>> addNewOptionToExistingCombinations(
        List<List<ProductOptionDetail>> existingCombinations,
        Product product,
        ProductOption newOption) {

        List<List<ProductOptionDetail>> newCombinations = new ArrayList<>();

        // ✅ 기존 조합을 유지하면서 새로운 옵션 값이 추가된 조합 생성
        for (List<ProductOptionDetail> existingCombination : existingCombinations) {
            for (ProductOptionDetail newDetail : newOption.getOptionDetails()) {
                List<ProductOptionDetail> newCombination = new ArrayList<>(existingCombination);
                newCombination.add(newDetail);  // 새 옵션 추가
                newCombinations.add(newCombination);
            }
        }

        return newCombinations;
    }

    // 옵션 조합 출력
    private static void printCombinations(List<List<ProductOptionDetail>> combinations) {
        for (List<ProductOptionDetail> combination : combinations) {
            System.out.println(combination.stream()
                                   .map(ProductOptionDetail::getValue)
                                   .collect(Collectors.joining(" + ")));
        }
    }

}
