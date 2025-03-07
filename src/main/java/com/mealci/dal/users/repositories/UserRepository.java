package com.mealci.dal.users.repositories;

import com.mealci.core.users.User;
import com.mealci.dal.users.UserEntity;
import com.mealci.dal.users.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);

    default User create(User user) {
        var entity = UserProfile.toEntity(user);
        var result = save(entity);

        return UserProfile.toDomain(result);
    }

    default Optional<User> findByEmailEntity(String email) {
        return findByEmail(email).map(UserProfile::toDomain);
    }

    Optional<UserEntity> findByEmail(String email);
}
