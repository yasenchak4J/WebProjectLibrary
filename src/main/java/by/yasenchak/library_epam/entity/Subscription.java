package by.yasenchak.library_epam.entity;

import java.io.Serializable;
import java.util.Objects;

public class Subscription implements Serializable {

    private static final long serialVersionUID = -4598533164524362668L;
    private int id;
    private String bookName;
    private int bookId;
    private int userId;
    private String dateIn;
    private String dateOut;
    private String userName;
    private String type;
    private String isbn;
    private boolean active;

    public Subscription(){

    }

    public Subscription(int bookName, int userName, String type, boolean active){
        this.bookId = bookName;
        this.userId = userName;
        this.type = type;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return getId() == that.getId() &&
                getBookName().equals(that.getBookName()) &&
                getUserName().equals(that.getUserName()) &&
                Objects.equals(getDateIn(), that.getDateIn()) &&
                Objects.equals(getDateOut(), that.getDateOut());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookName(), getDateIn(), getDateOut(), getUserName());
    }

}
