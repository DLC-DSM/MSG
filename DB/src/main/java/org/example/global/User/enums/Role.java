package org.example.global.User.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {

    ART_USER("ART_USER"),
    PLANT_USER("PLANT_USER"),
    DRAW_USER("DRAW_USER"),
    JOG_USER("JOG_USER"),
    BOOK_USER("BOOK_USER"),
    GROUP_USER("GROUP_USER"),
    GROUP_LEADER("GROUP_LEADER");


    private final String role;
}
