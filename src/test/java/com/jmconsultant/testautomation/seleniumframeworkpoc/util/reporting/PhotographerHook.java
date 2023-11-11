package com.jmconsultant.testautomation.seleniumframeworkpoc.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.UUID;

public class PhotographerHook {

    @Autowired
    private ApplicationContext ctx;

    @After
    public void takeScreenshot(Scenario scenario){
        final byte[] screenshot = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", UUID.randomUUID().toString());
    }
}
