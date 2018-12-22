package by.yasenchak.library_epam.entity;

import java.io.Serializable;

public class Genre implements Serializable {
    private static final long serialVersionUID = 3644371445320968983L;
    private int id;
    private String name;

    public Genre(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genre.getName().equals(getName());
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName().hashCode();
        return result;
    }


}
