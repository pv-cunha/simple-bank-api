package com.transactiontransferworker.api.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Value("${swagger.config.title}")
    private String title;

    @Value("${swagger.config.description}")
    private String description;

    @Value("${swagger.config.basePath:/cards}")
    private String basePath;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .description(description)
                        .license(new License()
                                .name("Apache License 2.0")
                                .url("http://springdoc.com"))
                        .contact(new Contact()
                                .name("Vieira ITSolutions")
                                .url("https://github.com/pv-cunha")
                                .email("pvcunha05@gmail.com")));
    }
}
