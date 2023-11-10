package com.jmconsultant.testautomation.seleniumframeworkpoc.conf;

import io.cucumber.spring.ScenarioScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;



@Configuration
public class DriverConfig {
    @Bean
    @ScenarioScope
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
