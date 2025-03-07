package com.mealci.core.authentication;

import com.mealci.core.email.Email;

public interface AuthenticationService {
    void validateEmailUniqeness(Email email);
}
