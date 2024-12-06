package com.mealci.core.authentication;

import com.mealci.core.authentication.login.LoginRequest;
import com.mealci.core.authentication.register.RegisterRequest;

public interface AuthenticationService {
    String register(RegisterRequest request);
    String login(LoginRequest request);
}
