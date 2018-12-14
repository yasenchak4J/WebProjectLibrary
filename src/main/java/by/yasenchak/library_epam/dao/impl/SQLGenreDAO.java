package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.GenreDAO;
import by.yasenchak.library_epam.database.ConnectionPoolImpl;
import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.dao_exception.GenreDAOException;
import by.yasenchak.library_epam.exception.dao_exception.LibraryDAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLGenreDAO implements GenreDAO {

    private static final String GET_ALL_GENRE = "SELECT * FROM genre";

    @Override
    public List<Genre> getAllGenre() throws GenreDAOException {
        List<Genre> genres = new ArrayList<>();
        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery(GET_ALL_GENRE)) {
            while(result.next()) {
                Genre genre = new Genre();
                genre.setId(result.getInt("id_genre"));
                genre.setName(result.getString("name"));
                genres.add(genre);
            }
        } catch (SQLException e) {
            throw new GenreDAOException("Problem with getAllBookMethod", e);
        }
        return genres;
    }
}
