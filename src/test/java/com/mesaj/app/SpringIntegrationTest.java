package com.mesaj.app;

import com.mesaj.app.config.DriverConfig;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = { Application.class , DriverConfig.class}, loader = SpringBootContextLoader.class)
public class SpringIntegrationTest {

    @Before
    public void setUp(){

    }
}
