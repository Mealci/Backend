package com.mealci.core.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Can't find current user");
    }
}
