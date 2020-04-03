package com.mesaj.app.util.driver;

import com.mesaj.app.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static String pathFormat = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/%s";

    public static WebDriver get(Browser browser){

        if(Browser.chrome == browser){
            System.setProperty("webdriver.chrome.driver", String.format(pathFormat, "chromedriver"));
            return new ChromeDriver();
        }

        if(Browser.firefox == browser){
            System.setProperty("webdriver.gecko.driver", String.format(pathFormat, "geckodriver"));
            return new FirefoxDriver();
        }

        throw new IllegalArgumentException("Driver not found for browser: " + browser);
    }
}
