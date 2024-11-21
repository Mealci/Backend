package com.mealci.api.controllers.authentication;

import com.mealci.core.authentication.register.RegisterRequest;
import com.mealci.core.authentication.register.RegisterService;
import com.mealci.core.exceptions.CoreException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private final RegisterService registerService;

    public AuthenticationController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        try {
            var result = registerService.register(registerRequest);

            return ResponseEntity.ok(result);
        }
        catch (CoreException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
