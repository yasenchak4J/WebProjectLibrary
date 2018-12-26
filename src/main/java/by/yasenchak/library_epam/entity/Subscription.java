package by.yasenchak.library_epam.entity;

import java.io.Serializable;
import java.util.Objects;

public class Subscription implements Serializable {

    private static final long serialVersionUID = -4598533164524362668L;
    private int id;
    private int bookId;
    private String dateIn;
    private String dateOut;
    private int userId;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return getId() == that.getId() &&
                getBookId() == that.getBookId() &&
                getUserId() == that.getUserId() &&
                Objects.equals(getDateIn(), that.getDateIn()) &&
                Objects.equals(getDateOut(), that.getDateOut());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookId(), getDateIn(), getDateOut(), getUserId());
    }
}
