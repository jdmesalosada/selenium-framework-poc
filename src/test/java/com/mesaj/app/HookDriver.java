package com.mesaj.app;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HookDriver {

    public static WebDriver driver;

    @Before
    public static void createDriver() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/drivers/mac/chromedriver");
        driver = new ChromeDriver();
    }
    @After
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
