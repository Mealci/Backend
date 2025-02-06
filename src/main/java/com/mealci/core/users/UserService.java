package com.mealci.core.users;

import com.mealci.core.results.Result;

public interface UserService {
    Result<User> getCurrentUser();
}
