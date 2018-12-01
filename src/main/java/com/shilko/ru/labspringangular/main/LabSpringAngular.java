package com.shilko.ru.labspringangular.main;

import com.shilko.ru.labspringangular.controller.ResultController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({"com.shilko.ru.labspringangular.controller","com.shilko.ru.labspringangular.serviceimpl"})
public class LabSpringAngular extends SpringBootServletInitializer {
        public static void main(String[] args) {
            SpringApplication.run(LabSpringAngular.class, args);
        }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LabSpringAngular.class);
    }
}
