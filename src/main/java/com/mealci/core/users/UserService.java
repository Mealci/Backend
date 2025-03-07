package com.mealci.core.users;

import com.mealci.core.email.Email;

public interface UserService {
    User getCurrentUser();
    User findUserByEmail(Email email);
}
