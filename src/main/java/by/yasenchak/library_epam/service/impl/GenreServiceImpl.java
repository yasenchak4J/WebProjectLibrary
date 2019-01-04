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
            throw new ServiceException("Something wrong with sql", e);
        }
    }

    @Override
    public Genre getGenreById(int id) throws ServiceException {
        try {
            return DAOFactory.getInstance().getGenreDAO().getGenreById(id);
        } catch (GenreDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public void changeGenre(Genre genre) throws ServiceException {
        try {
            DAOFactory.getInstance().getGenreDAO().changeGenre(genre);
        } catch (GenreDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }

    @Override
    public void addNewGenre(Genre genre) throws ServiceException {
        try {
            DAOFactory.getInstance().getGenreDAO().addNewGenre(genre);
        } catch (GenreDAOException e) {
            throw new ServiceException("Problem with SQL", e);
        }
    }
}
