package com.mesaj.app.conf;

import com.mesaj.app.enums.Browser;
import com.mesaj.app.util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;

@Configuration
@ComponentScan(basePackages = "com.mesaj.app")
@PropertySource("classpath:/application.properties")
public class DriverConfig {

    //TODO crear doS aarchivos diferentes y en cada uno especificar un browser dierente y pasar la variable por linea de comando
    // modificar esto @PropertySource("classpath:/application.properties")
    @Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int webdDriverWaitTimeOut;

    @Bean
    public WebDriver webDriver() {
        return DriverFactory.get(driverType);
    }

    @Bean
    public WebDriverWait waitFor(){
        return new WebDriverWait(webDriver(), Duration.ofSeconds(webdDriverWaitTimeOut));
    }
}
