package com.codecool.web.dao.database;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask3Dao extends AbstractDao implements Task3Dao {
    
    public DatabaseTask3Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task3Result> findAll() throws SQLException {
        List<Task3Result> task3Results = new ArrayList<>();
        String sql = "select company_name as company\n" +
                    "from suppliers\n" +
                    "join products\n" +
                    "\ton suppliers.supplier_id = products.supplier_id\n" +
                    "\tgroup by suppliers.company_name\n" +
                    "\thaving count(products.product_name) > 4\n" +
                    "\torder by company_name asc;";
        
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                task3Results.add(fetchResult(resultSet));
            }
        }
        return task3Results;
    }
    
    private Task3Result fetchResult(ResultSet resultSet) throws SQLException {
        
        String companyName = resultSet.getString("company");
        return new Task3Result(companyName);
    }
}
