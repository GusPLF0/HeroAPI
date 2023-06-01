package com.hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class HeroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroApiApplication.class, args);
    }

}
