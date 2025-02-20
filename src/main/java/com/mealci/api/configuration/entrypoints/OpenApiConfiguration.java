package com.mealci.api.configuration.entrypoints;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    public static final String BEARER_AUTH = "BearerAuth";
    public static final String PERMIT_ALL = "PermitAll";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Mealci")
                        .version("1.0")
                        .description("Documentation de l'API avec Swagger"))
                .addSecurityItem(new SecurityRequirement().addList(BEARER_AUTH))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(BEARER_AUTH,
                                new SecurityScheme()
                                        .name(BEARER_AUTH)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
