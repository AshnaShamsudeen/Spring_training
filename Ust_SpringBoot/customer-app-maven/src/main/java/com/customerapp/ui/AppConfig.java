package com.customerapp.ui;

import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
@ComponentScan(basePackages = {"com.customerapp.repository","com.customerapp.service"})
@Configuration
public class AppConfig {
    @Bean
    public Scanner getScannerBean() {
        return new Scanner(System.in);

    }
}
