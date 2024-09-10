package org.example.global.User.entity;

import jakarta.persistence.*;
import org.example.global.User.enums.Role;

@Entity
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

}
