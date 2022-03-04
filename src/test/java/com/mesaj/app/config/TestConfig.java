package com.mesaj.app.config;

import io.cucumber.java.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.mesaj.app")
@PropertySource("classpath:/application-${environment:dev}.properties")
public class TestConfig {

}
