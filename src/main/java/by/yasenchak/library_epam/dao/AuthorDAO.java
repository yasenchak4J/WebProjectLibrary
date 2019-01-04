package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.Author;
import by.yasenchak.library_epam.exception.dao_exception.AuthorDAOException;

import java.util.List;

public interface AuthorDAO {

    List<Author> getAllAuthors() throws AuthorDAOException;
    void deleteAuthor(int idAuthor) throws AuthorDAOException;
    Author getAuthorByID(int idAuthor) throws AuthorDAOException;
    void changeAuthor(Author author) throws AuthorDAOException;
    void addNewAuthor(Author author) throws AuthorDAOException;
}
