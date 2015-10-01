package com.shestakam.user.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Public class <code>User/code> is one of entities
 * classes. Its content is fully consistent with Table users
 * in database, which we use for. The main role is to store
 * associated with the table information(data).
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * unique identifier of instance
     */
    private Long id;

    /**
     * parameter describe username of entity
     */
    private String username;

    /**
     * parameter describe password of user
     */
    private String password;

    /**
     * parameter describe email address of user
     */
    private String email;

    /**
     * parameter which contains roles of user
     */
    private Set<Role> roleSet = new HashSet<>(0);


    public User() {
    }


    @Id
    @GeneratedValue
    @Column(name ="id",unique = true,nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name="username",unique = true ,nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    @Column(name = "password" , nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email",  nullable = false, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",catalog = "coffeeMarket", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "role_id",
                    nullable = false, updatable = false) })
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return !(email != null ? !email.equals(user.email) : user.email != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
