package org.example.global.User.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.global.User.List.RoleList;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_manage_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private RoleList role;
}
