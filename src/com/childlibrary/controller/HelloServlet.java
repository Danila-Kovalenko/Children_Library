package com.childlibrary.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Установка типа контента
        response.setContentType("text/html;charset=UTF-8");
        
        // Получение параметра из запроса
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            name = "Гость";
        }
        
        // Генерация ответа
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Приветствие</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Привет, " + name + "!</h1>");
            out.println("<a href=\"index.jsp\">Вернуться на главную</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    // Метод для обработки POST-запросов
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
