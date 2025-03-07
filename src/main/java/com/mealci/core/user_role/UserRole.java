package com.mealci.core.user_role;

import lombok.Getter;

@Getter
public enum UserRole {
    USER(1),
    ADMIN(2);

    private final int value;

    UserRole(int value) {
        this.value = value;
    }

    public static UserRole fromValue(int value) {
        for (UserRole role : UserRole.values()) {
            if (role.getValue() == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
