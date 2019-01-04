package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.dao_exception.GenreDAOException;

import java.util.List;

public interface GenreDAO {
    List<Genre> getAllGenre() throws GenreDAOException;
    Genre getGenreById(int idGenre) throws GenreDAOException;
    void changeGenre(Genre genre) throws GenreDAOException;
    void addNewGenre(Genre genre) throws GenreDAOException;
}
