package com.mealci.core.jwt;

import com.mealci.core.users.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    private static final String SECRET_KEY = "yourSecretKey";  // Clé secrète pour signer le token
    private static final long EXPIRATION_TIME = 3600000;

    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .claim("firstName", user.firstName)
                .claim("lastName", user.lastName)
                .claim("email", user.email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
