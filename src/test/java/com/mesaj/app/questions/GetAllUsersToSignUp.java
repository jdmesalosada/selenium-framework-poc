package com.mesaj.app.questions;

import com.mesaj.app.models.User;
import com.mesaj.app.util.files.excel.ConvertExcelSheet;

import java.util.List;

public class GetAllUsersToSignUp {


    public static List<User> fromDataSource() throws Exception {
        ConvertExcelSheet convertExcelSheet =
                new ConvertExcelSheet(System.getProperty("user.dir") + "/src/test/resources/data/data.xlsx", "logindata");

        return convertExcelSheet.to(User.class);
    }
}
