package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BookService {

    List<Book> getAllBooks() throws ServiceException;
    void addNewBook(Book book) throws ServiceException;
    void editBook(Book book) throws ServiceException;
    Book getBookByID(int id) throws ServiceException;
    List<Book> getBookByGenre(Genre genre) throws  ServiceException;
}
