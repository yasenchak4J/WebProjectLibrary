package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.LibraryDAO;
import by.yasenchak.library_epam.database.ConnectionPoolImpl;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.dao_exception.LibraryDAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLLibraryDAO implements LibraryDAO {
    private static final String ADD_NEW_BOOK_QUERY = "INSERT INTO books (name, \"pageCount\", publisher, image, isbn) VALUES (?,?,?,?,?);";
    private static final String GET_ALL_BOOKS_QUERY = "SELECT * FROM books;";
    private static final String GET_BOOK_BY_ID = "SELECT * FROM books where id_book= ? ;";
    private String EDIT_BOOK_QUERY = "UPDATE books SET name= ? , \"pageCount\" = ? , publisher = ? , image = ? , isbn= ? WHERE id_book =";
    private String EDIT_BOOK_WITHOUT_IMAGE = "UPDATE books SET name= ? , \"pageCount\" = ? , publisher = ? , isbn= ? WHERE id_book = ?";

    @Override
    public List<Book> getAllBook() throws LibraryDAOException {
        List<Book> books = new ArrayList<>();

        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery(GET_ALL_BOOKS_QUERY)) {
            while(result.next()) {
                books.add(executeSelectQuery(result));
            }
        } catch (SQLException e) {
            throw new LibraryDAOException("Problem with getAllBookMethod", e);
        }
        return books;
    }

    @Override
    public void addNewBook(Book book) throws LibraryDAOException {
        executeUpdateSQLQuery(ADD_NEW_BOOK_QUERY, book);
    }

    @Override
    public void editBook(Book book) throws LibraryDAOException {
        EDIT_BOOK_QUERY = EDIT_BOOK_QUERY + book.getId() + ";";
        executeUpdateSQLQuery(EDIT_BOOK_QUERY, book);
    }

    @Override
    public void editBookWitoutImage(Book book) throws LibraryDAOException {
        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); PreparedStatement pstmt = conn.prepareStatement(EDIT_BOOK_WITHOUT_IMAGE)) {
            pstmt.setString(1, book.getName());
            pstmt.setInt(2, book.getPageCount());
            pstmt.setString(3, book.getPublisher());
            pstmt.setString(4, book.getiSBN());
            pstmt.setInt(5, book.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LibraryDAOException("Problems with query", e);
        }
    }

    @Override
    public Book getBookById(int id) throws LibraryDAOException {
        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); PreparedStatement statement = conn.prepareStatement(GET_BOOK_BY_ID)) {
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
        }
    }

    private Book executeSelectQuery(ResultSet result) throws SQLException {
        Book book = new Book();
        book.setId(result.getInt("id_book"));
        book.setName(result.getString("name"));
        book.setiSBN(result.getString("isbn"));
        book.setImagePath(result.getString("image"));
        book.setPageCount(result.getInt("pageCount"));
        book.setPublisher(result.getString("publisher"));
        return book;
    }

    private void executeUpdateSQLQuery(String SQLquery, Book book) throws LibraryDAOException {
        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQLquery)) {
            pstmt.setString(1, book.getName());
            pstmt.setInt(2, book.getPageCount());
            pstmt.setString(3, book.getPublisher());
            pstmt.setString(4, book.getImagePath());
            pstmt.setString(5, book.getiSBN());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LibraryDAOException("Problems with query", e);
        }
    }

}
