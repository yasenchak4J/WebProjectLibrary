package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.entity.Author;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class AddNewAuthor implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            String surname = request.getParameter(RequestParameter.SURNAME.getCode());
            String name = request.getParameter(RequestParameter.NAME.getCode());
            Author author = new Author(0, name, surname);
            ServiceFactory.getInstance().getAuthorService().addNewAuthor(author);
            request.setAttribute(RequestParameter.AUTHORS.getCode(), ServiceFactory.getInstance().getAuthorService().getAllAuthors());
            return Page.ALL_AUTHORS.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }

    }
}
