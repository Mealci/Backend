package com.mealci.core.users;

import com.mealci.core.email.Email;
import com.mealci.core.exceptions.NotFoundException;
import com.mealci.core.jwt.JwtService;
import com.mealci.dal.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public UserServiceImpl(JwtService jwtService,
                           UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public User getCurrentUser() {
        var email = jwtService.extractEmail();
        var user = userRepository.findByEmailEntity(email);

        if (user.isEmpty()) {
            throw new NotFoundException("user not found");
        }

        return user.get();
    }

    @Override
    public User findUserByEmail(Email email) {
        var user = userRepository.findByEmailEntity(email.address);
        if (user.isEmpty()) {
            throw new NotFoundException(String.format("User not found by email : %s", email.address));
        }

        return user.get();
    }
}
