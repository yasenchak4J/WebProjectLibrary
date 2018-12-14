package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.ServiceException;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenre() throws ServiceException;
}
