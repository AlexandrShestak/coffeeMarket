package com.shestakam.user.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexandr on 19.8.15.
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id" , unique = true , nullable = false)
    private Long id;

    @Column(name = "role")
    private String role;


    @ManyToMany()
    @JoinTable(name = "user_roles", catalog = "coffeeMarket", joinColumns = {
            @JoinColumn(name = "role_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "user_id",
                    nullable = false, updatable = false) })
    private Set<User> usersSet = new HashSet<>(0);

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<User> usersSet) {
        this.usersSet = usersSet;
    }
}
