package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.AuthorDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.Author;
import by.yasenchak.library_epam.exception.dao_exception.AuthorDAOException;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.utils.DataBaseField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLAuthorDAO implements AuthorDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String GET_ALL_AUTHORS = "SELECT * FROM author";
    private static final String DELETE_AUTHOR = "DELETE FROM author WHERE id_author = ?";
    private static final String GET_AUTHOR_BY_ID = "SELECT * FROM author WHERE id_author = ?";
    private static final String CHANGE_AUTHOR = "UPDATE author SET \"Surname\" = ?, \"authorName\" = ? WHERE id_author = ?";
    private static final String ADD_NEW_AUTHOR = "INSERT INTO author(\"Surname\", \"authorName\") VALUES (?, ?)";

    @Override
    public List<Author> getAllAuthors() throws AuthorDAOException {
        List<Author> authors = new ArrayList<>();
        try(Connection conn = connectionPool.takeConnection(); Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(GET_ALL_AUTHORS)) {
            while(result.next()) {
                Author author = new Author();
                author.setId(result.getInt(DataBaseField.ID_AUTHOR.getCode()));
                author.setName(result.getString(DataBaseField.AUTHOR_NAME.getCode()));
                author.setSurname(result.getString(DataBaseField.SURNAME.getCode()));
                authors.add(author);
            }
            return authors;
        }  catch (ConnectionPoolException | SQLException e) {
            throw new AuthorDAOException("Problem with getAllAuthor", e);
        }
    }

    @Override
    public void deleteAuthor(int idAuthor) throws AuthorDAOException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AUTHOR)){
            preparedStatement.setInt(1, idAuthor);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new AuthorDAOException("Problem with deleteAuthor", e);
        }
    }

    @Override
    public Author getAuthorByID(int idAuthor) throws AuthorDAOException {
        try (Connection connection = connectionPool.takeConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_AUTHOR_BY_ID)){
            preparedStatement.setInt(1, idAuthor);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getInt(DataBaseField.ID_AUTHOR.getCode()));
                author.setSurname(resultSet.getString(DataBaseField.SURNAME.getCode()));
                author.setName(resultSet.getString(DataBaseField.AUTHOR_NAME.getCode()));
                return author;
            } else return null;
        } catch (SQLException | ConnectionPoolException e) {
            throw new AuthorDAOException("Problem with getAuthorByID", e);
        }
    }

    @Override
    public void changeAuthor(Author author) throws AuthorDAOException {
        try (Connection connection = connectionPool.takeConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_AUTHOR)){
            preparedStatement.setString(1, author.getSurname());
            preparedStatement.setString(2, author.getName());
            preparedStatement.setInt(3, author.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new AuthorDAOException("Problem with changeAuthor", e);
        }
    }

    @Override
    public void addNewAuthor(Author author) throws AuthorDAOException {
        try (Connection connection = connectionPool.takeConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_AUTHOR)){
            preparedStatement.setString(1, author.getSurname());
            preparedStatement.setString(2, author.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new AuthorDAOException("Problem with addNewAuthor", e);
        }
    }
}
