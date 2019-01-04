package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.GenreDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.exception.dao_exception.GenreDAOException;
import by.yasenchak.library_epam.utils.DataBaseField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLGenreDAO implements GenreDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String GET_ALL_GENRE = "SELECT * FROM genre";
    private static final String GET_GENRE_BY_ID = "SELECT * FROM genre WHERE id_genre = ?";
    private static final String CHANGE_GENRE = "UPDATE genre SET \"genreName\" = ? WHERE id_genre = ?";
    private static final String ADD_NEW_GENRE = "INSERT INTO genre (\"genreName\") VALUES (?)";

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

    @Override
    public Genre getGenreById(int idGenre) throws GenreDAOException {
        try(Connection connection = connectionPool.takeConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_GENRE_BY_ID)){
            preparedStatement.setInt(1, idGenre);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Genre genre = new Genre();
                genre.setName(resultSet.getString(DataBaseField.GENRE_NAME.getCode()));
                genre.setId(resultSet.getInt(DataBaseField.ID_GENRE.getCode()));
                return genre;
            }else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new GenreDAOException("Problem with getGenreById", e);
        }
    }

    @Override
    public void changeGenre(Genre genre) throws GenreDAOException {
        try(Connection connection = connectionPool.takeConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_GENRE)){
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setInt(2, genre.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new GenreDAOException("Problem with changeGenre", e);
        }
    }

    @Override
    public void addNewGenre(Genre genre) throws GenreDAOException {
        try(Connection connection = connectionPool.takeConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_GENRE)){
            preparedStatement.setString(1, genre.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new GenreDAOException("Problem with addNewGenre", e);
        }
    }
}
