package com.mealci.dal.users.repositories;

import com.mealci.dal.users.UserEntity;

public interface CustomUserRepository {
    UserEntity getByEmail(String email);
}
