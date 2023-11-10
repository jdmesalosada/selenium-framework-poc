package com.jmconsultant.testautomation.seleniumframeworkpoc.questions;

import com.jmconsultant.testautomation.seleniumframeworkpoc.models.User;
import com.jmconsultant.testautomation.seleniumframeworkpoc.util.files.excel.ConvertExcelSheet;

import java.util.List;

public class GetAllUsersToSignUp {
    public static List<User> fromDataSource() throws Exception {
        ConvertExcelSheet convertExcelSheet =
                new ConvertExcelSheet(System.getProperty("user.dir") + "/src/test/resources/data/data.xlsx", "logindata");

        return convertExcelSheet.to(User.class);
    }
}
