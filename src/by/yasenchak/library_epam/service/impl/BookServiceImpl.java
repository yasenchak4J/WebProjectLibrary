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
        try {
            List<Book> books = libraryDAO.getAllBook();
            return books;
        } catch (LibraryDAOException e) {
            throw new ServiceException("Problem with sql", e);
        }
    }

    @Override
    public void addNewBook(Book book) throws ServiceException {
        if(book == null || book.getName() == null){
            throw new ServiceException("Incorrect book");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibraryDAO libraryDAO = daoFactory.getLibraryDAO();
        try {
            libraryDAO.addNewBook(book);
        } catch (LibraryDAOException e) {
            throw new ServiceException("Problems with sql", e);
        }
    }

    @Override
    public void editBook(Book book) throws ServiceException {
        if(book == null || book.getName() == null){
            throw new ServiceException("Incorrect data for edit");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibraryDAO libraryDAO = daoFactory.getLibraryDAO();
        try {
            libraryDAO.editBook(book);
        } catch (LibraryDAOException e) {
            throw new ServiceException("Problems with sql", e);
        }
    }

    @Override
    public Book getBookByID(int id) throws ServiceException {
        if(id < 0){
            throw new ServiceException("Incorrect id");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibraryDAO libraryDAO = daoFactory.getLibraryDAO();
        try {
            Book book = libraryDAO.getBookById(id);
            return book;
        } catch (LibraryDAOException e) {
            throw new ServiceException("Problem with sql", e);
        }
    }
}
