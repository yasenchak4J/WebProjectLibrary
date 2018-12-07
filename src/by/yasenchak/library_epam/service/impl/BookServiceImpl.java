package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.LibraryDAO;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.dao_exception.LibraryDAOException;
import by.yasenchak.library_epam.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getAllBooks() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibraryDAO libraryDAO = daoFactory.getLibraryDAO();
        List<Book> books;
        try {
            books = libraryDAO.getAllBook();
        } catch (LibraryDAOException e) {
            throw new ServiceException("Problem with sql", e);
        }
        return books;
    }
}
