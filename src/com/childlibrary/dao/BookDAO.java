// File: src/com/childlibrary/dao/BookDAO.java
package com.childlibrary.dao;

import com.childlibrary.model.Book;
import com.childlibrary.model.Author;
import com.childlibrary.model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/child_library?useSSL=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private static final String INSERT_BOOK_SQL = "INSERT INTO books (title, author_id, category_id, year, isbn) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE id = ?;";
    private static final String UPDATE_BOOK_SQL = "UPDATE books SET title = ?, author_id = ?, category_id = ?, year = ?, isbn = ? WHERE id = ?;";

    public BookDAO() {}

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

    // Методы для книг

    public void insertBook(Book book) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getAuthor().getId());
            preparedStatement.setInt(3, book.getCategory().getId());
            preparedStatement.setInt(4, book.getYear());
            preparedStatement.setString(5, book.getIsbn());
            preparedStatement.executeUpdate();
        }
    }

    public Book getBookById(int id) {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                int authorId = rs.getInt("author_id");
                int categoryId = rs.getInt("category_id");
                int year = rs.getInt("year");
                String isbn = rs.getString("isbn");

                // Получение автора и категории
                AuthorDAO authorDAO = new AuthorDAO();
                CategoryDAO categoryDAO = new CategoryDAO();
                Author author = authorDAO.getAuthorById(authorId);
                Category category = categoryDAO.getCategoryById(categoryId);

                book = new Book(id, title, author, category, year, isbn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int authorId = rs.getInt("author_id");
                int categoryId = rs.getInt("category_id");
                int year = rs.getInt("year");
                String isbn = rs.getString("isbn");

                // Получение автора и категории
                AuthorDAO authorDAO = new AuthorDAO();
                CategoryDAO categoryDAO = new CategoryDAO();
                Author author = authorDAO.getAuthorById(authorId);
                Category category = categoryDAO.getCategoryById(categoryId);

                books.add(new Book(id, title, author, category, year, isbn));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public boolean updateBook(Book book) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_SQL);) {
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthor().getId());
            statement.setInt(3, book.getCategory().getId());
            statement.setInt(4, book.getYear());
            statement.setString(5, book.getIsbn());
            statement.setInt(6, book.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
