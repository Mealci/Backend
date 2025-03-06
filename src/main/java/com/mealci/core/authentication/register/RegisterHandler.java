package com.mealci.core.authentication.register;

import an.awesome.pipelinr.Command;
import com.mealci.core.authentication.AuthenticationService;
import com.mealci.core.email.Email;
import com.mealci.core.jwt.JwtService;
import com.mealci.core.password.PasswordService;
import com.mealci.core.user_role.UserRole;
import com.mealci.core.users.User;
import com.mealci.dal.users.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler implements Command.Handler<RegisterCommand, String> {
    private final AuthenticationService authenticationService;
    private final PasswordService passwordService;
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public RegisterHandler(AuthenticationService authenticationService,
                           PasswordService passwordService,
                           UserRepository userRepository,
                           JwtService jwtService,
                           BCryptPasswordEncoder encoder) {
        this.authenticationService = authenticationService;
        this.passwordService = passwordService;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    @Override
    public String handle(RegisterCommand command) {
        var request = command.request();
        var email = Email.create(request.email());
        authenticationService.validateEmailUniqeness(email);

        var password = request.password();
        passwordService.checkPasswordPolicy(password);

        var hashedPassword = encoder.encode(password);
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
