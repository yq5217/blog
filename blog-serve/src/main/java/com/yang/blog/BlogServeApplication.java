package com.yang.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BlogServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogServeApplication.class, args);
    }

}
