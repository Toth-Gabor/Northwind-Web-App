package com.codecool.web.dao.database;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task2Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask2Dao extends AbstractDao implements Task2Dao {
    
    DatabaseTask2Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task2Result> findAll() throws SQLException {
        List<Task2Result> task2Results = new ArrayList<>();
    
        String sql = "SELECT company_name AS company,\n" +
            "       count(products.product_name) AS products\n" +
            "FROM suppliers\n" +
            "         JOIN products\n" +
            "              ON suppliers.supplier_id = products.supplier_id\n" +
            "GROUP BY company_name\n" +
            "ORDER BY products DESC, company_name ASC;";
    
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                task2Results.add(fetchResult(resultSet));
            }
        }
        return task2Results;
    }
    
    private Task2Result fetchResult(ResultSet resultSet) throws SQLException {
        
        String companyName = resultSet.getString("company");
        int products = resultSet.getInt("product");
        return new Task2Result(companyName, products);
    }
}
