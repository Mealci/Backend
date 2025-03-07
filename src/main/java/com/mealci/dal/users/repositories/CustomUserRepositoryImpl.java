package com.mealci.dal.users.repositories;

import com.mealci.core.exceptions.NotFoundException;
import com.mealci.dal.users.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
    private final UserRepository userRepository;

    public CustomUserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getByEmail(String email) {
        var user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        return user.get();
    }
}
