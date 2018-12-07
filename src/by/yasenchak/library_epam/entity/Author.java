package by.yasenchak.library_epam.entity;

import java.io.Serializable;

public class Author implements Serializable {
    private static final long serialVersionUID = -7496647294059691785L;
    private String authorName;
    private String authorSurname;

    public Author(){

    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return author.getAuthorName().equals(getAuthorName()) &&
                author.getAuthorSurname().equals(getAuthorSurname());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getAuthorName().hashCode();
        result = prime * result + getAuthorSurname().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass() + " Author{" +
                "authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                '}';
    }
}
