package by.yasenchak.library_epam.service.impl;

import by.yasenchak.library_epam.dao.DAOFactory;
import by.yasenchak.library_epam.dao.GenreDAO;
import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.ServiceException;
import by.yasenchak.library_epam.exception.dao_exception.GenreDAOException;
import by.yasenchak.library_epam.service.GenreService;


import java.util.List;

public class GenreServiceImpl implements GenreService {
    @Override
    public List<Genre> getAllGenre() throws ServiceException {
        GenreDAO genreDAO = DAOFactory.getInstance().getGenreDAO();
        try {
            return genreDAO.getAllGenre();
        } catch (GenreDAOException e) {
            throw new ServiceException("Somthing wrong with sql", e);
        }
    }
}
