package com.mealci.core.password;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public boolean isPasswordValid(String password) {
        return password != null
                && password.length() >= 8
                && Pattern.compile("[A-Z]").matcher(password).find()
                && Pattern.compile("[a-z]").matcher(password).find()
                && Pattern.compile("\\d").matcher(password).find()
                && Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find();
    }
}
