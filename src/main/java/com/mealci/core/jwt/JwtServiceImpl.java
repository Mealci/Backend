package com.mealci.core.jwt;

import com.mealci.api.configuration.JwtConfig;
import com.mealci.core.users.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    private final JwtConfig jwtConfig;
    private static final long EXPIRATION_TIME = 3600000;

    // Constructor injection
    public JwtServiceImpl(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    public String generateToken(User user) {
        // Convert the secret string into a SecretKey
        SecretKey secretKey = Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());

        return Jwts.builder()
                .claim("firstName", user.firstName)
                .claim("lastName", user.lastName)
                .claim("email", user.email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }
}
