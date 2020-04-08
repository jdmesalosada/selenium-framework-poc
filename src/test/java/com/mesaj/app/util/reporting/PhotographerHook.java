package com.mesaj.app.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class PhotographerHook {

    @Autowired
    private WebDriver webDriver;

    @After
    public void takeScreenShot(Scenario scenario) {

        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png", UUID.randomUUID().toString());
            }
        } catch (WebDriverException wde) {
            System.out.println("There was an error taking the screenshot: " + wde.getMessage());
        }

    }
}
