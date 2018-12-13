package by.yasenchak.library_epam.logic.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.EnumPages;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class GetBookById implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        try {
            Book book = bookService.getBookByID(Integer.parseInt(request.getParameter("id")));
            if(book != null){
                request.setAttribute("book", book);
                response = EnumPages.EDIT_PAGE.getCode();
            } else {
                response = EnumPages.ERROR_PAGE.getCode();
            }
        } catch (ServiceException e) {
            response = EnumPages.ERROR_PAGE.getCode();
        }
        return response;
    }
}
