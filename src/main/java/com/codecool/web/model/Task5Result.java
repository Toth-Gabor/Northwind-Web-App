package com.codecool.web.model;

public class Task5Result {
    
    private String company;
    private String product;
    private String price;
    
    public Task5Result(String company, String product, String price) {
        this.company = company;
        this.product = product;
        this.price = price;
    }
    
    public String getCompany() {
        return company;
    }
    
    public String getProduct() {
        return product;
    }
    
    public String getPrice() {
        return price;
    }
}
