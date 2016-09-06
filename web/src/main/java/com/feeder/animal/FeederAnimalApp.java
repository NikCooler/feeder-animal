package com.feeder.animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Nik Smirnov. Created on 06.09.2016.
 */

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class FeederAnimalApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FeederAnimalApp.class, args);
    }

}
