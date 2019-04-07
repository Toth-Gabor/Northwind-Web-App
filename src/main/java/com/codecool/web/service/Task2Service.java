package com.codecool.web.service;

import com.codecool.web.model.Task2Result;

import java.sql.SQLException;
import java.util.List;

public interface Task2Service {
    
    List<Task2Result> getResults() throws SQLException;
}
