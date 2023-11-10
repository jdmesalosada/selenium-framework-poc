package com.jmconsultant.testautomation.seleniumframeworkpoc.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class SignupStepDefs {

    @Autowired
    private WebDriver driver;
    @Given("Pepito wants to have an account")
    public void pepito_wants_to_have_an_account() {
        driver.get("http://www.google.com");
    }

}
