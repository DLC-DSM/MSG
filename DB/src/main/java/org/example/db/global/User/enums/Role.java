package org.example.db.global.User.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {

    ART_USER("ROLE_ART_USER"),
    PLANT_USER("ROLE_PLANT_USER"),
    DRAW_USER("ROLE_DRAW_USER"),
    JOG_USER("ROLE_JOG_USER"),
    BOOK_USER("ROLE_BOOK_USER"),
    GROUP_USER("ROLE_GROUP_USER"),
    GROUP_LEADER("ROLE_GROUP_LEADER");


    private final String role;
}
