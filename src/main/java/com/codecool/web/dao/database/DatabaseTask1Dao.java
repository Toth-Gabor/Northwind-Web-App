package com.codecool.web.dao.database;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask1Dao extends AbstractDao implements Task1Dao {
    
    public DatabaseTask1Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task1Result> findAll() throws SQLException {
        
        List<Task1Result> task1Results = new ArrayList<>();
        
        String sql = "select product_name as product,\n" +
                    "company_name as company\n" +
                    "from products \n" +
                    "join suppliers \n" +
                    "on products.supplier_id = suppliers.supplier_id\n" +
                    "order by product, company asc";
        
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                task1Results.add(fetchResult(resultSet));
            }
        }
        return task1Results;
    }
    
    private Task1Result fetchResult(ResultSet resultSet) throws SQLException {
        
        String productName = resultSet.getString("product");
        String companyName = resultSet.getString("company");
        return new Task1Result(productName, companyName);
    }
}
