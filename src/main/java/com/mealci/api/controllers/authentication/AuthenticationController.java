package com.mealci.api.controllers.authentication;

import an.awesome.pipelinr.Pipeline;
import com.mealci.api.configuration.entrypoints.OpenApiConfiguration;
import com.mealci.core.authentication.login.LoginCommand;
import com.mealci.core.authentication.login.LoginRequest;
import com.mealci.core.authentication.register.RegisterCommand;
import com.mealci.core.authentication.register.RegisterRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final Pipeline pipeline;

    public AuthenticationController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @SecurityRequirement(name = OpenApiConfiguration.PERMIT_ALL)
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        var result = new RegisterCommand(request).execute(pipeline);

        return ResponseEntity.ok(result);
    }

    @SecurityRequirement(name = OpenApiConfiguration.PERMIT_ALL)
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        var result = new LoginCommand(request).execute(pipeline);

        return ResponseEntity.ok(result);
    }
}
