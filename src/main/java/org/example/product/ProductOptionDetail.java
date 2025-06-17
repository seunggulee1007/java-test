package org.example.product;

public class ProductOptionDetail {
    private Long id;
    private String value;
    private Long optionId; // 어떤 옵션 종류에 속하는지 참조

    public ProductOptionDetail(Long id, String value, Long optionId) {
        this.id = id;
        this.value = value;
        this.optionId = optionId;
    }
    public String getValue() {
        return value;
    }
}