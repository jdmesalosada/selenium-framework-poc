package com.jmconsultant.testautomation.seleniumframeworkpoc.conf;

import com.jmconsultant.testautomation.seleniumframeworkpoc.enums.Browser;
import com.jmconsultant.testautomation.seleniumframeworkpoc.util.driver.DriverFactory;
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

    @Autowired
    private DriverFactory driverFactory;

    @Value("${browser}")
    private Browser browser;

    @Bean(destroyMethod = "quit")
    @ScenarioScope
    public WebDriver webDriver() {
        return driverFactory.get(browser);
    }
}
