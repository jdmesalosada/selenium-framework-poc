package com.jmconsultant.testautomation.seleniumframeworkpoc.tasks;

import com.jmconsultant.testautomation.seleniumframeworkpoc.models.User;
import com.jmconsultant.testautomation.seleniumframeworkpoc.util.RandomNumberGenerator;
import com.jmconsultant.testautomation.seleniumframeworkpoc.pageobjects.SignUpServices;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class UserSignUp {

    @Autowired
    private SignUpServices signUp;

    public void withInfo(User user) {

        signUp.writeFirstName(user.getFirstName());
        /*signUp.writeLastName(user.getLastName());
        signUp.writeEmail(user.getEmail());
        signUp.selectGender(user.getGender());
        signUp.selectCountry(user.getCountry());
        signUp.selectBirthDay(user.getBirthDay());
        signUp.selectBirthMonth(user.getBirthMonth());
        signUp.selectBirthYear(user.getBirthYear());
        signUp.writePhone(RandomNumberGenerator.get());
        signUp.writePassword(user.getPassword());
        signUp.writeConfirmPassword(user.getPasswordConfirmation());
        signUp.clickOnSubmit();*/
    }
}
