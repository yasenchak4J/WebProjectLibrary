package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.LibraryDAO;
import by.yasenchak.library_epam.dao.connection_pool.ConnectionPool;
import by.yasenchak.library_epam.entity.Author;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.entity.Genre;
import by.yasenchak.library_epam.exception.dao_exception.ConnectionPoolException;
import by.yasenchak.library_epam.exception.dao_exception.LibraryDAOException;
import by.yasenchak.library_epam.utils.DataBaseField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLLibraryDAO implements LibraryDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String ADD_NEW_BOOK = "INSERT INTO books (name, \"pageCount\", publisher, image, isbn) VALUES (?,?,?,?,?);";
    private static final String GET_ALL_BOOKS = "SELECT books.name, books.isbn, books.\"pageCount\", books.publisher, books.id_book, books.image,  genre.\"genreName\", genre.id_genre, author.id_author, author.\"authorName\", author.\"Surname\"" +
            " FROM books LEFT OUTER JOIN genre ON (books.id_genre = genre.id_genre) LEFT OUTER JOIN author ON (books.id_author = author.id_author)";
    private static final String GET_BOOK_BY_ID = "SELECT books.name, books.isbn, books.\"pageCount\", books.publisher, books.id_book, books.image,  genre.\"genreName\", genre.id_genre, author.id_author, author.\"authorName\", author.\"Surname\"" +
            " FROM books LEFT OUTER JOIN genre ON (books.id_genre = genre.id_genre) LEFT OUTER JOIN author ON (books.id_author = author.id_author) WHERE books.id_book = ?";
    private String EDIT_BOOK = "UPDATE books SET name= ? , \"pageCount\" = ? , publisher = ? , image = ? , isbn= ? WHERE id_book =";
    private String EDIT_BOOK_WITHOUT_IMAGE = "UPDATE books SET name= ? , \"pageCount\" = ? , publisher = ? , isbn= ? WHERE id_book = ?";
    private String GET_BOOK_BY_GENRE = "SELECT books.name, books.isbn, books.\"pageCount\", books.publisher, books.id_book, books.image, genre.id_genre, genre.\"genreName\", author.\"authorName\", author.id_author, author.\"Surname\"" +
            " FROM books LEFT OUTER JOIN genre ON (books.id_genre = genre.id_genre) LEFT OUTER JOIN author ON (books.id_author = author.id_author) WHERE  genre.\"genreName\"= ?";
    private String DELETE_BOOK_BY_ID = "DELETE FROM books WHERE id_book = ?";
    private String SEARCH_BOOK = "SELECT books.name, books.isbn, books.\"pageCount\", books.publisher, books.id_book, books.image, genre.\"genreName\", genre.id_genre, author.id_author, author.\"authorName\", author.\"Surname\"" +
            " FROM books LEFT OUTER JOIN genre ON (books.id_genre = genre.id_genre) LEFT OUTER JOIN author ON (books.id_author = author.id_author) WHERE books.name LIKE ?";

    @Override
    public List<Book> getAllBook() throws LibraryDAOException {
        List<Book> books = new ArrayList<>();

        try(Connection conn = connectionPool.takeConnection(); Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(GET_ALL_BOOKS)) {

            while(result.next()) {
                books.add(executeSelectQuery(result));
            }
        } catch (SQLException e) {
            throw new LibraryDAOException("Problem with getAllBookMethod", e);
        } catch (ConnectionPoolException e) {
            throw new LibraryDAOException("Problems with connection pool", e);
        }
        return books;
    }

    @Override
    public void addNewBook(Book book) throws LibraryDAOException {
        executeUpdateSQLQuery(ADD_NEW_BOOK, book);
    }

    @Override
    public void editBook(Book book) throws LibraryDAOException {
        EDIT_BOOK = EDIT_BOOK + book.getId() + ";";
        executeUpdateSQLQuery(EDIT_BOOK, book);
    }

    @Override
    public void editBookWitoutImage(Book book) throws LibraryDAOException {
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement pstmt = conn.prepareStatement(EDIT_BOOK_WITHOUT_IMAGE)) {

            pstmt.setString(1, book.getName());
            pstmt.setInt(2, book.getPageCount());
            pstmt.setString(3, book.getPublisher());
            pstmt.setString(4, book.getiSBN());
            pstmt.setInt(5, book.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LibraryDAOException("Problems with query", e);
        } catch (ConnectionPoolException e) {
            throw new LibraryDAOException("Problems with connection pool", e);
        }
    }

    @Override
    public Book getBookById(int id) throws LibraryDAOException {
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(GET_BOOK_BY_ID)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return executeSelectQuery(result);
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new LibraryDAOException("problem with getBookById", e);
        } catch (ConnectionPoolException e) {
            throw new LibraryDAOException("Problems with connection pool", e);
        }
    }

    @Override
    public List<Book> getBookByGenre(String genreName) throws LibraryDAOException {
        List<Book> books = new ArrayList<>();
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(GET_BOOK_BY_GENRE)) {

            statement.setString(1, genreName);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                books.add(executeSelectQuery(result));
            }
        } catch (SQLException e) {
            throw new LibraryDAOException("problem with getBookByGenre", e);
        } catch (ConnectionPoolException e) {
            throw new LibraryDAOException("Problems with connection pool", e);
        }
        return books;
    }

    @Override
    public void deleteBookById(int id) throws LibraryDAOException {
        try(Connection conn =connectionPool.takeConnection();
            PreparedStatement pstmt = conn.prepareStatement(DELETE_BOOK_BY_ID)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new LibraryDAOException("problem with deleteBook", e);
        }
    }

    @Override
    public List<Book> searchBook(String text) throws LibraryDAOException {
        List<Book> books = new ArrayList<>();
        try(Connection conn = connectionPool.takeConnection();
            PreparedStatement statement = conn.prepareStatement(SEARCH_BOOK)) {

            statement.setString(1, "%" + text + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                books.add(executeSelectQuery(result));
            }
        } catch (SQLException e) {
            throw new LibraryDAOException("problem with searchBook", e);
        } catch (ConnectionPoolException e) {
            throw new LibraryDAOException("Problems with connection pool", e);
        }
        return books;
    }

    private Book executeSelectQuery(ResultSet result) throws SQLException {
        Author author = new Author();
        Genre genre = new Genre();
        Book book = new Book();

        author.setName(result.getString(DataBaseField.AUTHOR_NAME.getCode()));
        author.setSurname(result.getString(DataBaseField.SURNAME.getCode()));
        author.setId(result.getInt(DataBaseField.ID_AUTHOR.getCode()));
        genre.setId(result.getInt(DataBaseField.ID_GENRE.getCode()));
        genre.setName(result.getString(DataBaseField.GENRE_NAME.getCode()));
        book.setId(result.getInt(DataBaseField.ID_BOOK.getCode()));
        book.setName(result.getString(DataBaseField.NAME.getCode()));
        book.setiSBN(result.getString(DataBaseField.ISBN.getCode()));
        book.setImagePath(result.getString(DataBaseField.IMAGE.getCode()));
        book.setPageCount(result.getInt(DataBaseField.PAGE_COUNT.getCode()));
        book.setPublisher(result.getString(DataBaseField.PUBLISHER.getCode()));
        book.setAuthors(author);
        book.setGenres(genre);

        return book;
    }

    private void executeUpdateSQLQuery(String SQLquery, Book book) throws LibraryDAOException {
        try(Connection conn =connectionPool.takeConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQLquery)) {

            pstmt.setString(1, book.getName());
            pstmt.setInt(2, book.getPageCount());
            pstmt.setString(3, book.getPublisher());
            pstmt.setString(4, book.getImagePath());
            pstmt.setString(5, book.getiSBN());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LibraryDAOException("Problems with query", e);
        } catch (ConnectionPoolException e) {
            throw new LibraryDAOException("Problems with connection pool", e);
        }
    }

}
