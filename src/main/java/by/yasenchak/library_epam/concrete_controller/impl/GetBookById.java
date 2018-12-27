package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class GetBookById implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        try {
            Book book = bookService.getBookByID(Integer.parseInt(request.getParameter(RequestParameter.ID.getCode())));
            if(book != null){
                request.setAttribute(RequestParameter.BOOK.getCode(), book);
                response = Page.EDIT_PAGE.getCode();
            } else {
                response = Page.ERROR_PAGE.getCode();
            }
        } catch (ServiceException e) {
            response = Page.ERROR_PAGE.getCode();
        }
        return response;
    }
}
