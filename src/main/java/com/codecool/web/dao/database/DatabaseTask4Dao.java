package com.codecool.web.dao.database;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask4Dao extends AbstractDao implements Task4Dao {
    
    public DatabaseTask4Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task4Result> findAll() throws SQLException {
        List<Task4Result> task4Results = new ArrayList<>();
        String sql = "select company_name as company,\n" +
                    "array_agg(orders.order_id) as order_ids\n" +
                    "from customers\n" +
                    "left join orders\n" +
                    "\ton customers.customer_id = orders.customer_id\n" +
                    "\tgroup by customers.company_name\n" +
                    "\torder by company_name asc;";
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                task4Results.add(fetchResult(resultSet));
            }
        }
        return task4Results;
    }
    
    private Task4Result fetchResult(ResultSet resultSet) throws SQLException {
        
        String companyName = resultSet.getString("company");
        Array orderIds = resultSet.getArray("order_ids");
        Short[] orders = (Short[]) orderIds.getArray();
        List<Short> ids = new ArrayList<>();
        for (Short order : orders) {
            ids.add(order);
        }
        return new Task4Result(companyName, ids);
    }
}
