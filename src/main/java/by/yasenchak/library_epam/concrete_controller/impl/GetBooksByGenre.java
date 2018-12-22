package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.concrete_controller.EnumPages;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetBooksByGenre implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String response = null;
        String genre = request.getParameter("genre");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        try {
            List<Book> books = bookService.getBookByGenre(genre);
            request.setAttribute("books", books);
            response = EnumPages.MAIN_PAGE.getCode();
        } catch (ServiceException e) {
            e.printStackTrace();
            response = EnumPages.ERROR_PAGE.getCode();
        }
        return response;
    }
}
