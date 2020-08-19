package com.xkx.swapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwapperDemoApplication {

    public static void main(String[] args) {

        // 访问链接    http://localhost:8081/swagger-ui.html#/
        SpringApplication.run(SwapperDemoApplication.class, args);
    }

}
