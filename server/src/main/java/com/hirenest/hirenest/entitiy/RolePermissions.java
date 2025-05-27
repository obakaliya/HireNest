package com.hirenest.hirenest.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles_permissions")
public class RolePermissions {
  @Id @GeneratedValue Integer id;

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false)
  @JsonBackReference
  private Role role;

  @ManyToOne
  @JoinColumn(name = "permission_id", nullable = false)
  Permission permission;
}
