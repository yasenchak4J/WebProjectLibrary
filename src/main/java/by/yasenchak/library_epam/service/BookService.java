package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks() throws ServiceException;
    void addNewBook(Book book) throws ServiceException;
    void editBook(Book book) throws ServiceException;
    Book getBookByID(int id) throws ServiceException;
    List<Book> getBookByGenre(String genreName) throws  ServiceException;
    void deleteBook(int id) throws  ServiceException;
    List<Book> searchBooks(String text) throws ServiceException;
}
