package com.codecool.web.model;

import java.util.List;

public class Task4Result {

    private String company;
    private List<Short> orderIds;
    
    public Task4Result(String company, List<Short> orderIds) {
        this.company = company;
        this.orderIds = orderIds;
    }
    
    public List<Short> getOrderIds() {
        return orderIds;
    }
    
    public String getCompany() {
        return company;
    }
}
