package by.yasenchak.library_epam.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -8228737910229286905L;
    private String name;
    private String password;

    public User() {
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
