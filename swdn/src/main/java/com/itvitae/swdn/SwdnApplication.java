package com.itvitae.swdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SwdnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwdnApplication.class, args);
    }

}
