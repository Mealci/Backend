package com.mealci.core.jwt;

import com.mealci.core.users.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    private final HttpServletRequest request;

    private static final long EXPIRATION_TIME = 3600000;

    public JwtServiceImpl(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String generateToken(User user) {
        var key = Keys.hmacShaKeyFor(this.secretKey.getBytes());

        return Jwts.builder()
                .claim("firstName", user.firstName)
                .claim("lastName", user.lastName)
                .claim("email", user.email.address)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    private Claims extractAllClaims(String token) {
        var key = Keys.hmacShaKeyFor(this.secretKey.getBytes());

        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    public boolean isTokenValid(String token) {
        return !isTokenExpired(token) && hasEmail(token);
    }

    public String extractEmail() {
        return getClaim(getToken(), "email", String.class);
    }

    public String extractEmail(String jwt) {
        return extractAllClaims(jwt).get("email", String.class);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private boolean hasEmail(String token) {
        return getClaim(token, "email", String.class) != null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private <T> T getClaim(String token, String claimKey, Class<T> claimType) {
        Claims claims = extractAllClaims(token);
        return claims.get(claimKey, claimType);
    }

    public String getToken() {
        return (String) request.getAttribute("jwt");
    }
}
