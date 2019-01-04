package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.entity.Author;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.dao_exception.AuthorDAOException;
import by.yasenchak.library_epam.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Author> getAllAuthors() throws ServiceException {
        try {
            return DAOFactory.getInstance().getAuthorDAO().getAllAuthors();
        } catch (AuthorDAOException e) {
            throw new ServiceException("Problems with SQL", e);
        }
    }

    @Override
    public void deleteAuthor(int idAuthor) throws ServiceException {
        try {
            DAOFactory.getInstance().getAuthorDAO().deleteAuthor(idAuthor);
        } catch (AuthorDAOException e) {
            throw new ServiceException("Problems with SQL", e);
        }
    }

    @Override
    public Author getAuthorById(int idAuthor) throws ServiceException {
        try {
            return DAOFactory.getInstance().getAuthorDAO().getAuthorByID(idAuthor);
        } catch (AuthorDAOException e) {
            throw new ServiceException("Problems with SQL", e);
        }
    }

    @Override
    public void changeAuthor(Author author) throws ServiceException {
        try {
            DAOFactory.getInstance().getAuthorDAO().changeAuthor(author);
        } catch (AuthorDAOException e) {
            throw new ServiceException("Problems with SQL", e);
        }
    }

    @Override
    public void addNewAuthor(Author author) throws ServiceException {
        try {
            DAOFactory.getInstance().getAuthorDAO().addNewAuthor(author);
        } catch (AuthorDAOException e) {
            throw new ServiceException("Problems with SQL", e);
        }
    }
}
