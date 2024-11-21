package com.mealci.core.authentication.register;

public record RegisterRequest(String email,
                              String password,
                              String firstName,
                              String lastName,
                              int age) { }
