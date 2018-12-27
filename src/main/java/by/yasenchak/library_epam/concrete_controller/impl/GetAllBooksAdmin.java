package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetAllBooksAdmin implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        try {
            List<Book> books = bookService.getAllBooks();
            request.setAttribute(RequestParameter.BOOKS.getCode(), books);
            response = Page.ADMIN_PAGE.getCode();
        } catch (ServiceException e) {
            response = Page.ERROR_PAGE.getCode();
        }
        return response;
    }
}
