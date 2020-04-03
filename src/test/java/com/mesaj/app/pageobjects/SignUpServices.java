package com.mesaj.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpServices {

    @Autowired
    private SignUpPageObject signUpPageObject;

    @Autowired
    private WebDriver driver;

    @Autowired
    WebDriverWait wait;

    public void go(String url) {
        this.driver.get(url);
    }

    public void writeFirstName(String firstName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.signUpPageObject.getFirstNameTextbox()));
        this.signUpPageObject.getFirstNameTextbox().sendKeys(firstName);
    }

    public void writeLastName(String lastName) {
        this.signUpPageObject.getLastName().sendKeys(lastName);
    }

    public void writeEmail(String email) {
        this.signUpPageObject.getEmailAddress().sendKeys(email);
    }

    public void writePhone(String phone) {
        this.signUpPageObject.getPhone().sendKeys(phone);
    }

    public void selectMale() {
        this.signUpPageObject.getGenderMale().click();
    }

    public void selectFemale() {
        this.signUpPageObject.getGenderFemale().click();
    }

    public void selectCountry(String country) {
        new Select(this.signUpPageObject.getCountry()).selectByValue(country);
    }

    public void selectBirthDay(String day) {
        new Select(this.signUpPageObject.getDateOfBirthDay()).selectByValue(day);
    }

    public void selectBirthMonth(String month) {
        new Select(this.signUpPageObject.getDateOfBirthMonth()).selectByValue(month);
    }

    public void selectBirthYear(String year) {
        new Select(this.signUpPageObject.getDateOfBirthYear()).selectByValue(year);
    }

    public void writePassword(String password) {
        this.signUpPageObject.getPassword().sendKeys(password);
    }

    public void writeConfirmPassword(String password) {
        this.signUpPageObject.getConfirmPassword().sendKeys(password);
    }

    public void clickOnSubmit() {
        this.signUpPageObject.getSubmit().click();
    }
}
