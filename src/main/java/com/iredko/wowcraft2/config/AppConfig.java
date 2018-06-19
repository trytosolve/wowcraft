package com.iredko.wowcraft2.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DbConfig.class)
@ComponentScan("com.iredko.wowcraft2")
public class AppConfig {
}
