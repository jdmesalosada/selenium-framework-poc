package com.mesaj.app.models;

import com.mesaj.app.enums.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String country;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String phone;
    private String password;
    private String passwordConfirmation;
}
