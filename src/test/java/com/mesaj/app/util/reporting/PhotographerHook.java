package com.mesaj.app.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class PhotographerHook {

    @Autowired
    private WebDriver driver;

    @Value("${take.screenshot.condition}")
    private TakeScreenshotCondition takeScreenshotCondition;

    @After
    public void takeScreenshotAfterScenario(Scenario scenario){
        if(TakeScreenshotCondition.endOfScenario == takeScreenshotCondition){
            takeScreenShot(scenario);
        }
    }

    @AfterStep
    public void takeScreenshotAfterEveryStep(Scenario scenario){
        if(TakeScreenshotCondition.everyStep == takeScreenshotCondition){
            takeScreenShot(scenario);
        }
    }

    @After
    public void takeScreenshotAfterFailingScenario(Scenario scenario){
        if(scenario.isFailed() && TakeScreenshotCondition.failingScenario == takeScreenshotCondition){
            takeScreenShot(scenario);
        }
    }

    private void takeScreenShot(Scenario scenario){
        try{
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", UUID.randomUUID().toString());
        }catch (WebDriverException e){
            System.out.println("There was an error taking the screenshot: " + e.getMessage());
        }

    }

}
