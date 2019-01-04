package by.yasenchak.library_epam.concrete_controller.impl;

import by.yasenchak.library_epam.concrete_controller.Command;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.service.ServiceFactory;
import by.yasenchak.library_epam.utils.Page;
import by.yasenchak.library_epam.utils.RequestParameter;

import javax.servlet.http.HttpServletRequest;

public class GoToChangeGenre implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            int idGenre = Integer.parseInt(request.getParameter(RequestParameter.ID.getCode()));
            request.setAttribute(RequestParameter.GENRES.getCode(), ServiceFactory.getInstance().getGenreService().getAllGenre());
            request.setAttribute(RequestParameter.CHANGE_GENRE.getCode(), ServiceFactory.getInstance().getGenreService().getGenreById(idGenre));
            return Page.ALL_GENRES.getCode();
        } catch (ServiceException e) {
            return Page.ERROR_PAGE.getCode();
        }
    }
}
