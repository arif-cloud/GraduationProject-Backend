package com.example.ArticleApi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Article API",
                version = "1.0.0",
                description = "Open source API containing data from various article websites",
                termsOfService = "",
                contact = @Contact(
                        name = "Arif Demiryas",
                        email = "arifdemiryas@hotmail.com"
                ),
                license = @License(
                        name = "License by ArticleApp",
                        url = "https://github.com/arif-cloud/MVVMSampleProject"
                )
        )
)
public class ArticleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApiApplication.class, args);
    }

}
