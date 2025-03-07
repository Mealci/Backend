package com.mealci.core.authentication;

import com.mealci.core.email.Email;
import com.mealci.core.exceptions.ConflictException;
import com.mealci.dal.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateEmailUniqeness(Email email) {
        var isEmailUnique = userRepository.existsByEmail(email.address);
        if (isEmailUnique) {
            throw new ConflictException(String.format("Email : %s, already exists", email.address));
        }
    }
}
