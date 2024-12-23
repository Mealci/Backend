package com.mealci.api.controllers.authentication;

import com.mealci.core.authentication.login.LoginRequest;
import com.mealci.core.authentication.register.RegisterRequest;
import com.mealci.core.authentication.AuthenticationService;
import com.mealci.core.exceptions.CoreException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService registerService) {
        this.authenticationService = registerService;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        try {
            var result = authenticationService.register(registerRequest);

            return ResponseEntity.ok(result);
        }
        catch (CoreException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            var result = authenticationService.login(loginRequest);

            return ResponseEntity.ok(result);
        }
        catch (CoreException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
