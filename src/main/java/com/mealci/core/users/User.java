package com.mealci.core.users;

import com.mealci.core.base.Entity;
import com.mealci.core.email.Email;
import com.mealci.core.exceptions.UnprocessableEntityException;
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

        checkUserValidity(firstName, lastName, age);

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

    private static void checkUserValidity(String firstName,
                                          String lastName,
                                          int age) {
        if (firstName == null || firstName.isEmpty()) {
            throw new UnprocessableEntityException("First name cannot be null or empty");
        }

        if (lastName == null || lastName.isEmpty()) {
            throw new UnprocessableEntityException("Last name cannot be null or empty");
        }

        if (age < 0 || age > 150) {
            throw new UnprocessableEntityException("Age must be between 0 and 150");
        }
    }
}
