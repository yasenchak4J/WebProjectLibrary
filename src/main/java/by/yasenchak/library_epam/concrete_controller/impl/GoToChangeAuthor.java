package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class GoToChangeAuthor implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            int idAuthor = Integer.parseInt(request.getParameter(RequestParameter.ID.getCode()));
            request.setAttribute(RequestParameter.AUTHORS.getCode(), ServiceFactory.getInstance().getAuthorService().getAllAuthors());
            request.setAttribute(RequestParameter.CHANGE_AUTHOR.getCode(), ServiceFactory.getInstance().getAuthorService().getAuthorById(idAuthor));
            return Page.ALL_AUTHORS.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
