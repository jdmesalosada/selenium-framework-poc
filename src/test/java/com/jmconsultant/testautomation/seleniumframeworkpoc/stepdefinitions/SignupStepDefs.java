package com.jmconsultant.testautomation.seleniumframeworkpoc.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ScenarioScope
public class SignupStepDefs {

    @Autowired
    private WebDriver driver;
    @Given("Pepito wants to have an account")
    public void pepito_wants_to_have_an_account() {
        driver.get("http://www.google.com");
    }

    @When("he sends required information to get the account")
    public void he_sends_required_information_to_get_the_account() {

    }
    @Then("he should be told that the account was not created")
    public void he_should_be_told_that_the_account_was_not_created() {
        assertThat(true).isEqualTo(false);
    }


}
