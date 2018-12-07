package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks() throws ServiceException;
}
