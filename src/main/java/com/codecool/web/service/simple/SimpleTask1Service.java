package com.codecool.web.service.simple;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1Result;
import com.codecool.web.service.Task1Service;

import java.sql.SQLException;
import java.util.List;

public class SimpleTask1Service implements Task1Service {
    
    private final Task1Dao task1Dao;
    
    public SimpleTask1Service(Task1Dao task1Dao) {
        this.task1Dao = task1Dao;
    }
    
    @Override
    public List<Task1Result> getResults() throws SQLException {
        return task1Dao.findAll();
    }
    
    @Override
    public List<Task1Result> getFilteredTask(String companyName) throws SQLException {
        return task1Dao.getFilteredTask(companyName);
    }
}
