package com.mealci.core.jwt;

import com.mealci.core.users.User;

public interface JwtService {
    String generateToken(User user);
    String extractEmail();
}
