package com.mealci.core.users;

import com.mealci.core.jwt.JwtService;
import com.mealci.core.results.Result;
import com.mealci.dal.users.UserRepository;
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
    public Result<Integer> getUserId() {
        var email = jwtService.extractEmail();
        try {
            var id = userRepository.findIdByEmail(email);
            return id.map(Result::success)
                .orElseGet(() -> Result.failure("User not found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
