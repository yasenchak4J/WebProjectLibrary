package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.LibraryDAO;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.Genre;
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
            if(book.getImagePath() == null){
                libraryDAO.editBookWitoutImage(book);
            }else {
                libraryDAO.editBook(book);
            }
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

    @Override
    public List<Book> getBookByGenre(Genre genre) throws ServiceException {
        if (genre == null){
            throw new ServiceException("Incorrect genre");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibraryDAO libraryDAO = daoFactory.getLibraryDAO();
        try{
            List<Book> books = libraryDAO.getBookByGenre(genre);
            return books;
        } catch (LibraryDAOException e) {
            throw new ServiceException("Problem wit sql", e);
        }
    }

    @Override
    public void deleteBook(int id) throws ServiceException {
        if (id < 0){
            throw new ServiceException("Incorrect id");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        LibraryDAO libraryDAO = daoFactory.getLibraryDAO();
        try {
            libraryDAO.deleteBookById(id);
        } catch (LibraryDAOException e) {
            throw new ServiceException("Problem with sql", e);
        }
    }

    @Override
    public List<Book> searchBooks(String text) throws ServiceException {
        if(text.isEmpty()){
            throw new ServiceException("Incorrect search parameter");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        LibraryDAO libraryDAO = daoFactory.getLibraryDAO();
        try {
            List<Book> books = libraryDAO.searchBook(text);
            return books;
        } catch (LibraryDAOException e) {
            throw new ServiceException("Problem with sql", e);
        }
    }
}
