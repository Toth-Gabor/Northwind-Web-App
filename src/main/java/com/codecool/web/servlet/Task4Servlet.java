package com.codecool.web.servlet;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.dao.database.DatabaseTask4Dao;
import com.codecool.web.model.Task4Result;
import com.codecool.web.service.Task4Service;
import com.codecool.web.service.simple.SimpleTask4Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task4"})
public class Task4Servlet extends AbstractServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){
            Task4Dao task4Dao = new DatabaseTask4Dao(connection);
            Task4Service task4Service = new SimpleTask4Service(task4Dao);
            List<Task4Result> task4Results = task4Service.getResults();
            
            req.setAttribute("task4Results", task4Results);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        req.getRequestDispatcher("task4.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
