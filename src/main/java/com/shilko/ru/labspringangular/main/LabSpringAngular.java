package com.shilko.ru.labspringangular.main;

import com.shilko.ru.labspringangular.controller.ResultController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan({"com.shilko.ru.labspringangular"})
@EntityScan("com.shilko.ru.labspringangular.model")
@EnableJpaRepositories("com.shilko.ru.labspringangular.repository")
public class LabSpringAngular extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(LabSpringAngular.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LabSpringAngular.class);
    }
}
