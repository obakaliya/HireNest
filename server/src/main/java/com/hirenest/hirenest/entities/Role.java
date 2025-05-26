package com.hirenest.hirenest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RolePermissions> rolePermissions;

    public Role(String name, List<RolePermissions> rolePermissions) {
        this.name = name;
        this.rolePermissions = rolePermissions;
    }

    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RolePermissions> getRolePermissions() {
        return rolePermissions;
    }
}
