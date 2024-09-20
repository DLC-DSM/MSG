package org.example.db.global.User.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.db.global.User.enums.Role;

@Entity
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

}
