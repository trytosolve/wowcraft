package com.iredko.wowcraft.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DbConfig.class)
@ComponentScan("com.iredko.wowcraft")
public class AppConfig {
}
