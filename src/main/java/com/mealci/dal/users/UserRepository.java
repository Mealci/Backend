package com.mealci.dal.users;

import com.mealci.core.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);

    default User create(User user) {
        var entity = UserProfile.toEntity(user);
        var result = save(entity);

        return UserProfile.toDomain(result);
    }
}
