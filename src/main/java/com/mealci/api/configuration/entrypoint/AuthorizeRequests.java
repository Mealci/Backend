package com.mealci.api.configuration.entrypoint;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * classe utilitaire pour configurer les authorisations urls
 */
public class AuthorizeRequests {

    private AuthorizeRequests() {
        throw new IllegalStateException("Utility SecurityDefault class");
    }

    public static void all(
            AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorize) {
        authorize
                .requestMatchers(AntPathRequestMatcher.antMatcher("/denied")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("**/oauth2/**")).permitAll()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll();
    }
}
