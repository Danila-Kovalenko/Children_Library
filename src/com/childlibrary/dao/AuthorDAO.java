// File: src/com/childlibrary/dao/AuthorDAO.java
package com.childlibrary.dao;

import com.childlibrary.model.Author;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/child_library?useSSL=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private static final String SELECT_ALL_AUTHORS = "SELECT * FROM authors";
    private static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM authors WHERE id = ?";

    public AuthorDAO() {}

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

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String biography = rs.getString("biography");
                authors.add(new Author(id, firstName, lastName, biography));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public Author getAuthorById(int id) {
        Author author = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String biography = rs.getString("biography");
                author = new Author(id, firstName, lastName, biography);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }
}
