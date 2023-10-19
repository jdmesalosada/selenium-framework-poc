package com.mesaj.app.util.driver;

import com.mesaj.app.enums.Browser;
import io.cucumber.spring.ScenarioScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;
@ScenarioScope
@Component
public class DriverFactory {

    private static String pathFormat = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/%s";

    @Value("${grid.url}")
    private String gridUrl;

    @Value("${remote.execution}")
    private boolean remoteExecution;

    public WebDriver get(Browser browser) throws MalformedURLException {

        if (remoteExecution)
            return getRemoteWebDriver(browser);

        if (Browser.chrome == browser) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        if (Browser.firefox == browser) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

        throw new IllegalArgumentException("Driver not found for browser: " + browser);
    }

    private RemoteWebDriver getRemoteWebDriver(Browser browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.name());

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        return new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
    }

}
