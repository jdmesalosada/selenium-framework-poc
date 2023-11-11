package com.jmconsultant.testautomation.seleniumframeworkpoc.util.driver;

import com.jmconsultant.testautomation.seleniumframeworkpoc.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {

    public WebDriver get(Browser browser){

        if(Browser.chrome == browser){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        if(Browser.firefox == browser){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

        throw new IllegalArgumentException("Browser not found: "+ browser);
    }
}
