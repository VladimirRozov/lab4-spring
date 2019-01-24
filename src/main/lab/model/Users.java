package main.lab.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "USERS")
public class Users implements Serializable {


    public Users(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }

    public Users(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(unique=true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;



    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (getClass() != o.getClass())
            return false;
        Users users = (Users) o;
        return id.equals(users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}