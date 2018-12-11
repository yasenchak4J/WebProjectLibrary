package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.controller.UploadServlet;
import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.LibraryDAO;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.dao_exception.LibraryDAOException;
import by.yasenchak.library_epam.service.BookService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    @Override
    public void updateImageById(HttpServletRequest request) throws ServiceException {
        Part part = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            part = request.getPart("file");
            String fileName = part.getSubmittedFileName();
            String path = request.getServletContext().getRealPath("images") + "\\" + fileName;
            System.out.println(path);
            InputStream stream = part.getInputStream();
            Files.copy(stream, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            path = "../images/" + fileName;
            DAOFactory daoFactory = DAOFactory.getInstance();
            LibraryDAO libraryDAO = daoFactory.getLibraryDAO();
            try {
                libraryDAO.updateImageById(id, path);
            } catch (LibraryDAOException e) {
                throw new ServiceException("Problem with sql", e);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
