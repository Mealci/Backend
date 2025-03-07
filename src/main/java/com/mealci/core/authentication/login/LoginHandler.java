package com.mealci.core.authentication.login;

import an.awesome.pipelinr.Command;
import com.mealci.core.email.Email;
import com.mealci.core.jwt.JwtService;
import com.mealci.core.users.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler implements Command.Handler<LoginCommand, String> {
    private final UserService userService;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder;

    public LoginHandler(UserService userService,
                        JwtService jwtService,
                        BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    @Override
    public String handle(LoginCommand command) {
        var request = command.request();
        var email = Email.create(request.email());
        var user = userService.findUserByEmail(email);
        var encodedPassword = user.password;
        encoder.matches(request.password(), encodedPassword);

        return jwtService.generateToken(user);
    }
}
