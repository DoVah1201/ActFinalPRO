package com.actfinal.ut7.src.main.java.com.actfinal.ut7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example1.prueba")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}