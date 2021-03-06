package com.mesaj.app.conf;

import com.mesaj.app.enums.Browser;
import com.mesaj.app.util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;
import java.time.Duration;

@Configuration
public class DriverConfig {

    @Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int webdDriverWaitTimeOut;

    @Autowired
    private DriverFactory driverFactory;

    @Scope("cucumber-glue")
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() throws MalformedURLException {
        return driverFactory.get(driverType);
    }

    @Bean
    @Scope("cucumber-glue")
    public WebDriverWait waitFor() throws MalformedURLException {
        return new WebDriverWait(webDriver(), Duration.ofSeconds(webdDriverWaitTimeOut));
    }
}
