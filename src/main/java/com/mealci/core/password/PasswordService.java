package com.mealci.core.password;

public interface PasswordService {
    boolean isPasswordValid(String password);
    String hash(String password);
}
