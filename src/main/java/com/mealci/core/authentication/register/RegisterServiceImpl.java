package com.mealci.core.authentication.register;

import com.mealci.core.email.Email;
import com.mealci.core.exceptions.CoreException;
import com.mealci.core.jwt.JwtService;
import com.mealci.core.password.PasswordService;
import com.mealci.core.user_role.UserRole;
import com.mealci.core.users.User;
import com.mealci.dal.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    private final PasswordService passwordService;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public RegisterServiceImpl(PasswordService passwordService,
                               UserRepository userRepository,
                               JwtService jwtService) {
        this.passwordService = passwordService;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public String register(RegisterRequest request) {
        var isEmailUnique = userRepository.existsByEmail(request.email());
        if (isEmailUnique) {
            throw new CoreException("Email already exists");
        }

        var password = request.password();
        if (passwordService.isPasswordValid(password)) {
            throw new CoreException("Password is incorrect format matching");
        }

        var hashedPassword = passwordService.hash(password);
        var email = Email.create(request.email());
        var user = User.create(request.firstName(),
                request.lastName(),
                email,
                hashedPassword,
                UserRole.USER,
                request.age());

        var result = userRepository.create(user);
        return jwtService.generateToken(result);
    }
}
