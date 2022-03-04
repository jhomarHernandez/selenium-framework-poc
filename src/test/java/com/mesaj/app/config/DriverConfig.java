package com.mesaj.app.config;

import com.mesaj.app.enums.Browser;
import com.mesaj.app.util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.time.Duration;

@Configuration
@ComponentScan(basePackages = "com.mesaj.app")
@PropertySource("classpath:/application-${environment:dev}.properties")
public class DriverConfig {

    @Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int webDriverWaitTimeOut;

    @Autowired
    private DriverFactory driverFactory;

    @Scope("cucumber-glue")
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(){
        return driverFactory.get(driverType);
    }

    @Scope("cucumber-glue")
    @Bean
    public WebDriverWait waitFor(){
        return new WebDriverWait(webDriver(), Duration.ofSeconds(webDriverWaitTimeOut));
    }

}
