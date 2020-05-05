package com.mesaj.app.questions;

import com.mesaj.app.exceptions.UserNotFoundException;
import com.mesaj.app.models.User;

public class GetUserToSignUpBy {

    public static User profile(String profile) throws Exception {
        return GetAllUsersToSignUp
                .fromDataSource()
                .stream()
                .filter(user -> user.getProfile().equalsIgnoreCase(profile))
                .findFirst().orElseThrow(() -> new UserNotFoundException("User not found in the datasource with profile " + profile));
    }

}
