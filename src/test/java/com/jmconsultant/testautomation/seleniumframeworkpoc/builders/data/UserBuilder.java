package com.jmconsultant.testautomation.seleniumframeworkpoc.builders.data;

import com.jmconsultant.testautomation.seleniumframeworkpoc.enums.Gender;
import com.jmconsultant.testautomation.seleniumframeworkpoc.models.User;
import com.jmconsultant.testautomation.seleniumframeworkpoc.util.RandomNumberGenerator;

public class UserBuilder {

    private User user;

    private UserBuilder() {
        user = User.builder().build();
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder but() {
        return withDefaultInfo();
    }

    public UserBuilder withDefaultInfo() {
        this.user = User.builder()
                .firstName("Pepito")
                .lastName("Perez")
                .email("Perez@gmail.com")
                .gender(Gender.male)
                .country("Colombia")
                .birthDay("10")
                .birthMonth("February")
                .birthYear("1989")
                .phone(RandomNumberGenerator.get())
                .password("A_x?a1989")
                .passwordConfirmation("A_x?a1989").build();
        return this;
    }

    public UserBuilder withoutEmail() {
        user.setEmail("");
        return this;
    }

    public UserBuilder withoutBirthDay() {
        user.setBirthDay("");
        return this;
    }

    public User build() {
        return this.user;
    }
}
