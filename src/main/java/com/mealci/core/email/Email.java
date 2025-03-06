package com.mealci.core.email;

import com.mealci.core.base.ValueObject;
import com.mealci.core.exceptions.UnprocessableEntityException;

public class Email extends ValueObject {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    public final String address;

    private Email(String address) {
        checkEmailValidity(address);

        this.address = address;
    }

    public static Email create(String address) {
        return new Email(address);
    }

    @Override
    protected String toStringAttributes() {
        return String.format("%s", address);
    }

    private static void checkEmailValidity(String email) {
        if (email == null || email.isEmpty() || !email.matches(EMAIL_PATTERN)) {
            throw new UnprocessableEntityException("Invalid email");
        }
    }
}
