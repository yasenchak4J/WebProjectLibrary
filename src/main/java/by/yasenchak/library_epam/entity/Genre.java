package by.yasenchak.library_epam.entity;

import java.io.Serializable;

public class Genre implements Serializable {
    private static final long serialVersionUID = 3644371445320968983L;
    private String genreName;

    public Genre(){

    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genre.getGenreName().equals(getGenreName());
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + getGenreName().hashCode();
        return result;
    }
}
