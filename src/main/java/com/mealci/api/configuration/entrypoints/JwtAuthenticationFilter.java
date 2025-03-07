package com.mealci.api.configuration.entrypoints;

import com.mealci.core.jwt.JwtServiceImpl;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION_HEADER_BEGINNING = "Bearer ";
    public static final String INVALID_TOKEN = "Invalid token";

    private final JwtServiceImpl jwtService;

    public JwtAuthenticationFilter(JwtServiceImpl jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws IOException {
        try {
            filterUserAuthorization(request, response, filterChain);
        } catch (Exception exception) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
        }
    }

    private void filterUserAuthorization(HttpServletRequest request,
                                         HttpServletResponse response,
                                         FilterChain filterChain) throws IOException, ServletException {
        var authorizationHeader = request.getHeader("Authorization");
        if (!hasBearerAuthorization(authorizationHeader)) {
            filterChain.doFilter(request, response);
            return;
        }

        var jwt = authorizationHeader.substring(AUTHORIZATION_HEADER_BEGINNING.length());
        if (!jwtService.isTokenValid(jwt)) {
            throw new JwtException(INVALID_TOKEN);
        }

        var context = SecurityContextHolder.getContext();
        if (context.getAuthentication() == null) {
            registerAuthorizedUser(request, jwt);
        }

        request.setAttribute("jwt", jwt);
        filterChain.doFilter(request, response);
    }

    private static boolean hasBearerAuthorization(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith(AUTHORIZATION_HEADER_BEGINNING);
    }

    private void registerAuthorizedUser(HttpServletRequest request, String jwt) {
        var email = jwtService.extractEmail(jwt);
        var role = jwtService.extractRole(jwt);
        var userDetails = new User(email, "", List.of(new SimpleGrantedAuthority(role)));
        var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
