package com.edsonveiga.biblioteca_digital.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Biblioteca Digital API")
                        .version("1.0")
                        .description("API para gerenciamento de livros e usuários de uma biblioteca digital."));
    }
}