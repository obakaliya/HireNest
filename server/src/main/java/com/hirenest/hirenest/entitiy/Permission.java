package com.hirenest.hirenest.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "permissions")
public class Permission {
  @Id @GeneratedValue private Integer id;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @OneToMany(mappedBy = "permission")
  @JsonBackReference
  private List<RolePermissions> rolePermissions;
}
