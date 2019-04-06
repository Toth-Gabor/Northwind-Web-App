package com.codecool.web.model;

public class Task2Result {

    private String company;
    private int count;
    
    public Task2Result(String company, int count) {
        this.company = company;
        this.count = count;
    }
    
    public String getCompany() {
        return company;
    }
    
    public int getCount() {
        return count;
    }
}
