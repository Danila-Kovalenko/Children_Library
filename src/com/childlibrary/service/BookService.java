package com.childlibrary.service;

import com.childlibrary.model.Book;
import com.childlibrary.dao.BookDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BookService {
    
    @Inject
    private BookDAO bookDAO;

    public void addBook(Book book) {
        bookDAO.insertBook(book);
    }

    public Book getBook(int id) {
        return bookDAO.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
