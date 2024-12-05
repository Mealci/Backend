package com.mealci.dal.users;

import com.mealci.core.email.Email;
import com.mealci.core.user_role.UserRole;
import com.mealci.core.users.User;

public class UserProfile {

    private UserProfile() {
        throw new IllegalStateException("Utility class");
    }


    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }

        var entity = new UserEntity();
        entity.setFirstName(user.firstName);
        entity.setLastName(user.lastName);
        entity.setEmail(user.email.address);
        entity.setPassword(user.password);
        entity.setRole(user.role.getValue());
        entity.setAge(user.age);

        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        return User.create(
                entity.firstName,
                entity.lastName,
                Email.create(entity.email),
                entity.password,
                UserRole.fromValue(entity.role),
                entity.getAge()
        );
    }
}
