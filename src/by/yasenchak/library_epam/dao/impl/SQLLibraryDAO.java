package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.LibraryDAO;
import by.yasenchak.library_epam.database.ConnectionPoolImpl;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.dao_exception.LibraryDAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLLibraryDAO implements LibraryDAO {

    @Override
    public List<Book> getAllBook() throws LibraryDAOException {
        List<Book> books = new ArrayList<>();
        String SQLquery = "SELECT * FROM books;" ;

        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery(SQLquery)) {
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
        String SQLquery = "INSERT INTO books (name, \"pageCount\", publisher, image, isbn) VALUES (?,?,?,?,?);";
        executeUpdateSQLQuery(SQLquery, book);
    }

    @Override
    public void editBook(Book book) throws LibraryDAOException {
        String SQLquery = "UPDATE books SET name= ? , \"pageCount\" = ? , publisher = ? , image = ? , isbn= ? WHERE id_book = " + book.getId() + ";";
        executeUpdateSQLQuery(SQLquery, book);
    }

    @Override
    public Book getBookById(int id) throws LibraryDAOException {
        String SQLquery = "SELECT * FROM books where id_book=" + id +";";
        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery(SQLquery)) {
            if(result.next()){
                return executeSelectQuery(result);
            }
            else {
                throw new LibraryDAOException("Book doesn't exist");
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
            throw new LibraryDAOException("Problems with addNewBook", e);
        }
    }

}
