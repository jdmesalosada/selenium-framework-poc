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

import java.net.MalformedURLException;
import java.time.Duration;

@Configuration
public class DriverConfig {

    /*@Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int webdDriverWaitTimeOut;*/

    @Autowired
    private DriverFactory driverFactory;

    /*@ScenarioScope
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() throws MalformedURLException {
        return driverFactory.get(driverType);
    }*/


    @Bean(destroyMethod = "quit")
    @ScenarioScope
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    @ScenarioScope
    public WebDriverWait waitFor() {
        return new WebDriverWait(webDriver(), Duration.ofSeconds(20L));
    }
}
