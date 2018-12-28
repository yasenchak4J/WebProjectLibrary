package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class WhatIsTheBookLibrarian implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter(RequestParameter.ID.getCode()));
        try {
            request.setAttribute(RequestParameter.BOOK.getCode(), ServiceFactory.getInstance().getBookService().getBookByID(bookId));
            return Page.LIBRARIAN_BOOK.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
