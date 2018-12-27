package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.GenreDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.exception.dao_exception.GenreDAOException;
import by.yasenchak.library_epam.utils.DataBaseField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLGenreDAO implements GenreDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String GET_ALL_GENRE = "SELECT * FROM genre";

    @Override
    public List<Genre> getAllGenre() throws GenreDAOException {
        List<Genre> genres = new ArrayList<>();
        try(Connection conn = connectionPool.takeConnection(); Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(GET_ALL_GENRE)) {

            while(result.next()) {
                Genre genre = new Genre();
                genre.setId(result.getInt(DataBaseField.ID_GENRE.getCode()));
                genre.setName(result.getString(DataBaseField.GENRE_NAME.getCode()));
                genres.add(genre);
            }
        }  catch (ConnectionPoolException | SQLException e) {
            throw new GenreDAOException("Problem with getAllGenre", e);
        }
        return genres;
    }
}
