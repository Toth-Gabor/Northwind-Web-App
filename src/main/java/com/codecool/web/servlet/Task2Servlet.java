package com.codecool.web.servlet;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.dao.database.DatabaseTask2Dao;
import com.codecool.web.model.Task2Result;
import com.codecool.web.service.Task2Service;
import com.codecool.web.service.simple.SimpleTask2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task2"})
public class Task2Servlet extends AbstractServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){
            Task2Dao task2Dao = new DatabaseTask2Dao(connection);
            Task2Service task2Service = new SimpleTask2Service(task2Dao);
            List<Task2Result> task2Results = task2Service.getResults();
            
            req.setAttribute("task2Results", task2Results);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        req.getRequestDispatcher("task2.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
