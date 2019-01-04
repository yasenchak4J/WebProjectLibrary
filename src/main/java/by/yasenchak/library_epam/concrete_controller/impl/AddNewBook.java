package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.RequestParameter;

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

public class AddNewBook implements Command {
    private static final String IMAGE_PATH = "images";

    @Override
    public String execute(HttpServletRequest request) {
        String response;
        Part part;
        try {
            Book book = new Book();
            book.setName(request.getParameter(RequestParameter.NAME.getCode()));
            book.setPublisher(request.getParameter(RequestParameter.PUBLISHER.getCode()));
            book.setPageCount(Integer.parseInt(request.getParameter(RequestParameter.PAGE_COUNT.getCode())));
            book.setiSBN(request.getParameter(RequestParameter.ISBN.getCode()));
            part = request.getPart(RequestParameter.FILE.getCode());

            if(!part.getSubmittedFileName().isEmpty()){
                String fileName = part.getSubmittedFileName();
                String formatImage = fileName.substring(fileName.length()-4);
                String uniqueName = UUID.randomUUID().toString();
                String path = request.getServletContext().getRealPath(IMAGE_PATH) + "\\" + uniqueName + formatImage;
                InputStream stream = part.getInputStream();
                Files.copy(stream, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
                path = IMAGE_PATH + "/" + uniqueName + formatImage;
                book.setImagePath(path);
            }
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BookService bookService = serviceFactory.getBookService();

            bookService.addNewBook(book);
            List<Book> books = bookService.getAllBooks();
            request.setAttribute(RequestParameter.BOOKS.getCode(), books);
            response = Page.ADMIN_PAGE.getCode();
        } catch (IOException | ServletException | ServiceException e) {
            e.printStackTrace();
            response = Page.ERROR_PAGE.getCode();
        }
        return response;
    }
}
