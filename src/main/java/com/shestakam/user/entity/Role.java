package com.shestakam.user.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id" , unique = true , nullable = false)
    private Long id;

    @Column(name = "role")
    private String role;



    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roleSet")
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
