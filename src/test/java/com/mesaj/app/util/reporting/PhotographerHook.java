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
    private WebDriver webDriver;

    @Value("${take.screenshot.condition:none}")
    private TakeScreenshotCondition takeScreenshotCondition;

    @After
    public void takeScreenshotAfterScenario(Scenario scenario) {
        if (TakeScreenshotCondition.everyStep == takeScreenshotCondition)
            takeScreenshot(scenario);
    }

    @AfterStep
    public void takeScreenshotAfterEveryStep(Scenario scenario) {
        if (TakeScreenshotCondition.everyStep == takeScreenshotCondition)
            takeScreenshot(scenario);
    }

    @After
    public void takeScreenshotAfterFailingScenario(Scenario scenario) {
        if (scenario.isFailed() && TakeScreenshotCondition.failingScenario == takeScreenshotCondition)
            takeScreenshot(scenario);
    }

    private void takeScreenshot(Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", UUID.randomUUID().toString());

        } catch (WebDriverException wde) {
            System.out.println("There was an error taking the screenshot: " + wde.getMessage());
        }
    }

}
