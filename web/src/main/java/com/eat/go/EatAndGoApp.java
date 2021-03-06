package com.eat.go;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Nik Smirnov
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableSwagger2
@ComponentScan(basePackages = "com.eat.go.*")
public class EatAndGoApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EatAndGoApp.class, args);
    }

}
