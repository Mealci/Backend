package com.mealci.core.users;

import com.mealci.core.email.Email;
import com.mealci.core.user_role.UserRole;
import lombok.Getter;

@Getter
public final class User {
    public final String firstName;
    public final String lastName;
    public final Email email;
    public final String password;
    public final UserRole role;
    public final int age;

    private User(String firstName,
                 String lastName,
                 Email email,
                 String password,
                 UserRole role,
                 int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.age = age;
    }

    public static User create(String firstName,
                              String lastName,
                              Email email,
                              String password,
                              UserRole role,
                              int age) {
        return new User(firstName,
                lastName,
                email,
                password,
                role,
                age);
    }
}
