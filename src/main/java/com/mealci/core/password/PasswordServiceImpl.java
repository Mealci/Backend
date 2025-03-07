package com.mealci.core.password;

import com.mealci.core.exceptions.UnprocessableEntityException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public void checkPasswordPolicy(String password) {
        var passwordPattern = password != null
                && password.length() >= 8
                && Pattern.compile("[A-Z]").matcher(password).find()
                && Pattern.compile("[a-z]").matcher(password).find()
                && Pattern.compile("\\d").matcher(password).find()
                && Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find();

        if (!passwordPattern) {
            throw new UnprocessableEntityException("Password does not meet security requirements");
        }
    }
}
