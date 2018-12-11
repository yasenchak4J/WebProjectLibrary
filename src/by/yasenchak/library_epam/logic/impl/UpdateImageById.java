package by.yasenchak.library_epam.logic.impl;

import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.logic.Command;
import by.yasenchak.library_epam.logic.EnumPages;
import by.yasenchak.library_epam.service.BookService;
import by.yasenchak.library_epam.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class UpdateImageById implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        try {
            bookService.updateImageById(request);
            page = EnumPages.EDIT_PAGE.getCode();
        } catch (ServiceException e) {
            page = EnumPages.ERROR_PAGE.getCode();
        }
        return page;
    }
}
