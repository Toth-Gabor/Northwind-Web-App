package com.codecool.web.dao.database;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask5Dao extends AbstractDao implements Task5Dao {
    
    public DatabaseTask5Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task5Result> findAll() throws SQLException {
        List<Task5Result> task5Results = new ArrayList<>();
        String sql = "SELECT\n" +
                    "    suppliers.company_name AS company,\n" +
                    "    products.product_name AS product,\n" +
                    "    products.unit_price AS unit_price\n" +
                    "FROM\n" +
                    "    products\n" +
                    "        INNER JOIN\n" +
                    "    suppliers ON suppliers.supplier_id = products.supplier_id\n" +
                    "        JOIN\n" +
                    "    (SELECT\n" +
                    "         products.supplier_id, max(products.unit_price) AS max_unit\n" +
                    "     FROM\n" +
                    "         products\n" +
                    "     GROUP BY products.supplier_id) AS try ON products.supplier_id = try.supplier_id\n" +
                    "        AND products.unit_price = try.max_unit\n" +
                    "ORDER BY unit_price DESC;";
    
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                task5Results.add(fetchResult(resultSet));
            }
        }
        return task5Results;
    }
    
    private Task5Result fetchResult(ResultSet resultSet) throws SQLException {
        
        String company = resultSet.getString("company");
        String product = resultSet.getString("product");
        String price = resultSet.getString("unit_price");
        
        return new Task5Result(company, product, price);
    }
}
