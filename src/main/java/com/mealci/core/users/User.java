package com.mealci.core.users;

import com.mealci.core.base.Entity;
import com.mealci.core.email.Email;
import com.mealci.core.user_role.UserRole;
import lombok.Getter;

@Getter
public final class User extends Entity<String> {
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
        super(email.address);
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
