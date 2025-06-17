package org.example.product;

import java.util.ArrayList;
import java.util.List;


public class ProductOption {
    private Long id;
    private String name;
    private List<ProductOptionDetail> optionDetails;

    public ProductOption(Long id, String name) {
        this.id = id;
        this.name = name;
        this.optionDetails = new ArrayList<>();
    }

    public void addOptionDetail(ProductOptionDetail detail) {
        optionDetails.add(detail);
    }

    public Long getId() {return id;}
    public String getName() {
        return name;
    }

    public List<ProductOptionDetail> getOptionDetails() {
        return optionDetails;
    }

}