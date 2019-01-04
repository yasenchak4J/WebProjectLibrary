package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class AddNewGenre implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            String name = request.getParameter(RequestParameter.NAME.getCode());
            Genre genre = new Genre();
            genre.setName(name);
            ServiceFactory.getInstance().getGenreService().addNewGenre(genre);
            request.setAttribute(RequestParameter.GENRES.getCode(), ServiceFactory.getInstance().getGenreService().getAllGenre());
            return Page.ALL_GENRES.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
