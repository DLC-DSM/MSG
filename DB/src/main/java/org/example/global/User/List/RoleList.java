package org.example.global.User.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleList {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ROLE_GROUP_ADMIN("ROLE_GROUP_ADMIN"),
    ROLE_GROUP_MEMBER("ROLE_GROUP_MEMBER");

    private final String role;
}
