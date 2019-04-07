package com.codecool.web.servlet;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.dao.database.DatabaseTask5Dao;
import com.codecool.web.model.Task5Result;
import com.codecool.web.service.Task5Service;
import com.codecool.web.service.simple.SimpleTask5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task5"})
public class Task5Servlet extends AbstractServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){
            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            Task5Service task5Service = new SimpleTask5Service(task5Dao);
            List<Task5Result> task5Results = task5Service.getResults();
            
            req.setAttribute("task5Results", task5Results);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        req.getRequestDispatcher("task5.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
