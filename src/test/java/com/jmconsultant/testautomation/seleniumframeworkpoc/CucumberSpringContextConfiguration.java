package com.jmconsultant.testautomation.seleniumframeworkpoc;

import com.jmconsultant.testautomation.seleniumframeworkpoc.conf.TestConfig;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = {TestConfig.class})
public class CucumberSpringContextConfiguration {

    @Before
    public void setup(){
        System.out.println("Context started!");
    }
}
