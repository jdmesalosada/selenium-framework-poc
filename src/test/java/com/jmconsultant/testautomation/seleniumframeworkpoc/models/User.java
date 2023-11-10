package com.jmconsultant.testautomation.seleniumframeworkpoc.models;

import com.jmconsultant.testautomation.seleniumframeworkpoc.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String firstName = "foo";
    private String lastName = "bar";
    private String email = "foo@gmail.com";
    private Gender gender = Gender.female;
    private String country = "Colombia";
    private String birthDay = "";
    private String birthMonth = "";
    private String birthYear = "";
    private String phone = "";
    private String password = "";
    private String passwordConfirmation = "";
    private String profile = "";
}
