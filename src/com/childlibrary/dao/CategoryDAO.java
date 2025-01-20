// File: src/com/childlibrary/dao/CategoryDAO.java
package com.childlibrary.dao;

import com.childlibrary.model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/child_library?useSSL=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM categories";
    private static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM categories WHERE id = ?";

    public CategoryDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                categories.add(new Category(id, name, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Category getCategoryById(int id) {
        Category category = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                category = new Category(id, name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
