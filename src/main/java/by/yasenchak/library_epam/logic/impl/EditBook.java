package by.yasenchak.library_epam.logic.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.EnumPages;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

public class EditBook implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String response = null;
        Part part;
        try {
            Book book = new Book();
            book.setId(Integer.parseInt(request.getParameter("id")));
            book.setName(request.getParameter("name"));
            book.setPublisher(request.getParameter("publisher"));
            book.setPageCount(Integer.parseInt(request.getParameter("pageCount")));
            book.setiSBN(request.getParameter("isbn"));
            part = request.getPart("file");

            if(!part.getSubmittedFileName().isEmpty()){
                String fileName = part.getSubmittedFileName();
                String formatImage = fileName.substring(fileName.length()-4);
                String uniqueName = UUID.randomUUID().toString();
                String path = request.getServletContext().getRealPath("images") + "\\" + uniqueName + formatImage;
                InputStream stream = part.getInputStream();
                Files.copy(stream, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
                path = "images/" + uniqueName + formatImage;
                book.setImagePath(path);
            }

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BookService bookService = serviceFactory.getBookService();
            bookService.editBook(book);
            List<Book> books = bookService.getAllBooks();
            request.setAttribute("books", books);
            response = EnumPages.ADMIN_PAGE.getCode();
        } catch (IOException | ServiceException | ServletException e) {
            response = EnumPages.ERROR_PAGE.getCode();
        }
        return response;
    }
}
