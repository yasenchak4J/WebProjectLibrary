package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class GoToAddNewGenre implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.setAttribute(RequestParameter.GENRES.getCode(), ServiceFactory.getInstance().getGenreService().getAllGenre());
            request.setAttribute(RequestParameter.NEW_GENRE.getCode(), new Genre());
            return Page.ALL_GENRES.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
