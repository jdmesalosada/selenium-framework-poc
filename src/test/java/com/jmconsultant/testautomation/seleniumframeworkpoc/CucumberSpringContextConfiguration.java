package com.jmconsultant.testautomation.seleniumframeworkpoc;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
public class CucumberSpringContextConfiguration {

    @Before
    public void setup(){
        System.out.println("Context started!");
    }
}
