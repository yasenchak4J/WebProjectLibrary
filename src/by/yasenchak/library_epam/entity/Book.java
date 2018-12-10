package by.yasenchak.library_epam.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Book implements Serializable {
    private static final long serialVersionUID = -5609354029228990166L;
    private String name;
    private int pageCount;
    private String iSBN;
    private String publisher;
    private Author authors;
    private Genre genres;
    private byte[] image;

    public Book() {
    }

    public Book(String name, int pageCount, String iSBN, String publisher, Author authors, Genre genres, byte[] image) {
        this.name = name;
        this.pageCount = pageCount;
        this.iSBN = iSBN;
        this.publisher = publisher;
        this.authors = authors;
        this.genres = genres;
        this.image = image;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthors() {
        return authors;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }

    public Genre getGenres() {
        return genres;
    }

    public void setGenres(Genre genres) {
        this.genres = genres;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getPageCount() == book.getPageCount() &&
                getName().equals(book.getName()) &&
                getiSBN().equals(book.getiSBN()) &&
                getPublisher().equals(book.getPublisher()) &&
                Arrays.equals(getImage(), book.getImage());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getPageCount(), getiSBN(), getPublisher());
        result = 31 * result + Arrays.hashCode(getImage());
        return result;
    }
}
