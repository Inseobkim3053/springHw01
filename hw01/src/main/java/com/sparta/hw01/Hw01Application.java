package com.sparta.hw01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hw01Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw01Application.class, args);
    }

}
