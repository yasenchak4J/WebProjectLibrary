package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.entity.Author;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class ChangeAuthor implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(RequestParameter.NAME.getCode());
        String surname = request.getParameter(RequestParameter.SURNAME.getCode());
        int idAuthor = Integer.parseInt(request.getParameter(RequestParameter.ID.getCode()));
        Author author = new Author(idAuthor, name, surname);
        try {
            ServiceFactory.getInstance().getAuthorService().changeAuthor(author);
            request.setAttribute(RequestParameter.AUTHORS.getCode(), ServiceFactory.getInstance().getAuthorService().getAllAuthors());
            return Page.ALL_AUTHORS.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
