package com.mealci.core.users;

import com.mealci.core.jwt.JwtService;
import com.mealci.core.results.Result;
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
    public Result<User> getCurrentUser() {
        var email = jwtService.extractEmail();
        var user = userRepository.findByEmailEntity(email);

        return user.map(Result::success)
                .orElseGet(() -> Result.failure("Can't find current user"));
    }
}
