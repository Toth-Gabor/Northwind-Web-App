package com.codecool.web.model;

import java.util.List;

public class Task4Result {

    private String company;
    private List<Integer> orderIds;
    
    public Task4Result(String company, List<Integer> orderIds) {
        this.company = company;
        this.orderIds = orderIds;
    }
    
    public List<Integer> getOrderIds() {
        return orderIds;
    }
    
    public String getCompany() {
        return company;
    }
}
