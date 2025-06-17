package org.example.product;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String description;
    private List<ProductOption> productOptions;

    public Product(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productOptions = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addOption(ProductOption option) {
        productOptions.add(option);
    }

    public List<ProductOption> getProductOptions() {
        return productOptions;
    }
}