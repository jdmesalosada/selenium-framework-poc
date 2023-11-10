package com.jmconsultant.testautomation.seleniumframeworkpoc.questions;

import com.jmconsultant.testautomation.seleniumframeworkpoc.exceptions.UserNotFoundException;
import com.jmconsultant.testautomation.seleniumframeworkpoc.models.User;

public class GetUserToSignUpBy {

    public static User profile(String profile) throws Exception {
        return GetAllUsersToSignUp
                .fromDataSource()
                .stream()
                .filter(user -> user.getProfile().equalsIgnoreCase(profile))
                .findFirst().orElseThrow(() -> new UserNotFoundException("User not found in the datasource with profile " + profile));
    }

}
