package com.codecool.web.model;

public class Task1Result {
    
    private String productName;
    private String companyName;
    
    public Task1Result(String productName, String companyName) {
        this.productName = productName;
        this.companyName = companyName;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public String getCompanyName() {
        return companyName;
    }
}
