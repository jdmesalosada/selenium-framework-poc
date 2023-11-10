package com.jmconsultant.testautomation.seleniumframeworkpoc.util.reporting;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@ScenarioScope
public class PhotographerHook {

    @Autowired
    private WebDriver webDriver;

    @Value("${take.screenshot.condition:none}")
    private TakeScreenshotCondition takeScreenshotCondition;

    /*@After
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
            scenario.attach(screenshot, "image/png", UUID.randomUUID().toString());

        } catch (WebDriverException wde) {
            System.out.println("There was an error taking the screenshot: " + wde.getMessage());
        }
    }*/
}
