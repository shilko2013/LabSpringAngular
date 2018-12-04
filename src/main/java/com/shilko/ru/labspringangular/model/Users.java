package com.shilko.ru.labspringangular.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

//@Type(type="text")

/**
 * The type Users.
 */
@Entity
@Data
public class Users implements Serializable {

    /**
     * Instantiates a new Users.
     *
     * @param username      the login
     * @param password   the password
     */
    public Users(@NotNull String username, @NotNull @Size(min = minPasswordSize) String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new Users.
     */
    public Users(){}

    @Transient
    private static final int minPasswordSize = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "guid")
    private String id;

    @Column(unique=true, nullable = false)
    private String username;

    @Column(nullable = false)
    @Size(min = minPasswordSize)
    private String password;

    @Column(nullable = false)
    private UserStatusEnum userStatus;

    public UserStatusEnum getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatusEnum userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * Gets min password size.
     *
     * @return the min password size
     */
    public static int getMinPasswordSize() {
        return minPasswordSize;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
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
        return id == users.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}