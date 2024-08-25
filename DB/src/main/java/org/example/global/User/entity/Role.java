package org.example.global.User.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String role_id;

    @OneToMany(mappedBy = "role")
    private List<UnionRoleUser> role;
}
