package com.wedu.ipsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wedu.ipsp"})
public class IpspApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpspApplication.class, args);
    }

}
