package org.example.global.User.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UnionRoleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
