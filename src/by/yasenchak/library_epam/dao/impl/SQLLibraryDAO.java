package by.yasenchak.library_epam.dao.impl;

import by.yasenchak.library_epam.dao.LibraryDAO;
import by.yasenchak.library_epam.database.ConnectionPoolImpl;
import by.yasenchak.library_epam.entity.Book;
import by.yasenchak.library_epam.exception.dao_exception.LibraryDAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLLibraryDAO implements LibraryDAO {

    @Override
    public List<Book> getAllBook() throws LibraryDAOException {
        List<Book> books = new ArrayList<>();
        String SQLquery = "SELECT * FROM books;" ;
        try(Connection conn = ConnectionPoolImpl.getInstance().getConnection(); Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery(SQLquery)) {
            if(result.next()) {
                Book book = new Book();
                book.setName(result.getString("name"));
                book.setiSBN(result.getString("isbn"));
                book.setImage(result.getBytes("image"));
                book.setPageCount(result.getInt("pageCount"));
                book.setPublisher(result.getString("publisher"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new LibraryDAOException("Problem with getAllBookMethod", e);
        }
        return books;
    }
}
