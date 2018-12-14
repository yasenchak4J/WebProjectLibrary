package by.yasenchak.library_epam.entity;

import java.io.Serializable;

public class Author implements Serializable {
    private static final long serialVersionUID = -7496647294059691785L;
    private int id;
    private String name;
    private String surname;

    public Author(){

    }

    public String getNameAndSurname(){
        return name + " " + surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
        Author author = (Author) o;
        return author.getName().equals(getName()) &&
                author.getSurname().equals(getSurname());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName().hashCode();
        result = prime * result + getSurname().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass() + " Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
