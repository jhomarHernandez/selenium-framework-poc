package com.mesaj.app.util.driver;

import com.mesaj.app.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {

    private static String path = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/%s";

    public static WebDriver get(Browser browser){
        if(Browser.chrome == browser){
            System.setProperty("webdriver.chrome.driver", String.format(path,"chromedriver.exe"));
            return new ChromeDriver();
        }
        if(Browser.firefox == browser){
            System.setProperty("webdriver.gecko.driver", String.format(path, "geckodriver.exe"));
            return new FirefoxDriver();
        }
        if(Browser.ie == browser){
            System.setProperty("webdriver.ie.driver", String.format(path, "internetexplorerdriver.exe"));
            return  new InternetExplorerDriver();
        }
        throw new IllegalArgumentException("Driver not found for browser: " + browser);
    }



}
