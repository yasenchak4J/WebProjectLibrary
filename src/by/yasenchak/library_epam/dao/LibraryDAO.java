package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.dao_exception.LibraryDAOException;

import java.util.List;

public interface LibraryDAO {
    List<Book> getAllBook() throws LibraryDAOException;
    void addNewBook(Book book) throws LibraryDAOException;
    void editBook(Book book) throws LibraryDAOException;
    Book getBookById(int id) throws LibraryDAOException;
    void updateImageById(int id, String path) throws LibraryDAOException;
}
