package com.mesaj.app.tasks;

import com.mesaj.app.models.User;
import com.mesaj.app.pageobjects.SignUpServices;
import com.mesaj.app.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class UserSignUp {

    @Autowired
    private SignUpServices signUp;

    public void withInfo(User user) {

        signUp.writeFirstName(user.getFirstName());
        signUp.writeLastName(user.getLastName());
        signUp.writeEmail(user.getEmail());
        signUp.selectGender(user.getGender());
        signUp.selectCountry(user.getCountry());
        signUp.selectBirthDay(user.getBirthDay());
        signUp.selectBirthMonth(user.getBirthMonth());
        signUp.selectBirthYear(user.getBirthYear());
        signUp.writePhone(RandomNumberGenerator.get());
        signUp.writePassword(user.getPassword());
        signUp.writeConfirmPassword(user.getPasswordConfirmation());
        //signUp.clickOnSubmit();
    }
}
