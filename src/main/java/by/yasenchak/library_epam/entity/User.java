package by.yasenchak.library_epam.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -8228737910229286905L;
    private String name;
    private String password;
    private int role;
    private int userId;
    private String gender;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String name, String password, int role, String gender, String firstName, String lastName) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String name, String password, int role, int userId, String gender, String firstName, String lastName) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.userId = userId;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        User user = (User) o;
        return user.getName().equals(getName()) &&
                user.getPassword().equals(getPassword());
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName().hashCode();
        result = prime * result + getPassword().hashCode();
        return result;
    }
}
