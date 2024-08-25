package org.example.global.User.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UnionRoleUser {

    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Role role;
}
