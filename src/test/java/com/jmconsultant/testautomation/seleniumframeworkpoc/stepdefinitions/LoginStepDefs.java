package com.jmconsultant.testautomation.seleniumframeworkpoc.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class LoginStepDefs {

    @Autowired
    private WebDriver driver;

    @Given("Pepito wants to log in")
    public void pepito_wants_to_log_in() {
        driver.get("https://www.mercadolibre.com.co/");
    }
}
