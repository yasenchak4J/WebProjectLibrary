package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.Author;
import by.yasenchak.library_epam.exception.ServiceException;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors() throws ServiceException;
    void deleteAuthor(int idAuthor) throws ServiceException;
    Author getAuthorById(int idAuthor) throws ServiceException;
    void changeAuthor(Author author) throws ServiceException;
    void addNewAuthor(Author author) throws ServiceException;
}
