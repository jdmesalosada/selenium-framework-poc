package com.mesaj.app.stepdefinitions;

import com.mesaj.app.HookDriver;
import com.mesaj.app.pageobjects.SignUpPageObject;
import com.mesaj.app.pageobjects.SignUpServices;
import com.mesaj.app.util.RandomNumberGenerator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpStepDefs {

    @Given("^Pepito wants to have an account$")
    public void pepito_wants_to_have_an_account() throws InterruptedException {

        SignUpServices signUp = new SignUpServices(HookDriver.driver);
        signUp.go("http://demo.automationtesting.in/Register.html");
        signUp.writeFirstName("Pepito");
        signUp.writeLastName("Perez");
        signUp.writeEmail("Perez@gmail.com");
        signUp.selectMale();
        signUp.selectCountry("Colombia");
        signUp.selectBirthDay("10");
        signUp.selectBirthMonth("February");
        signUp.selectBirthYear("1989");
        signUp.writePhone(RandomNumberGenerator.get());
        signUp.writePassword("A_x?a1989");
        signUp.writeConfirmPassword("A_x?a1989");

        signUp.clickOnSubmit();

        Thread.sleep(8000);
    }

    @When("^he sends required information to get the account$")
    public void he_sends_required_information_to_get_the_account() {
    }

    @Then("^he should be told that the account was created$")
    public void he_should_be_told_that_the_account_was_created() {
    }
}
