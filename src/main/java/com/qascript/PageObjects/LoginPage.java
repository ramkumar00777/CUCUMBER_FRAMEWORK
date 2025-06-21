package com.qascript.PageObjects;

import com.qascript.BaseClass;
import com.qascript.Utils.BrowserUtils;
import com.qascript.Utils.ExcelUtils;

import java.util.List;

public class LoginPage extends BaseClass
{
    static String txtusername = "//input[@id='user-name']";
    static String txtpassword = "//input[@id='password']";
    static String txtlogin = "//input[@id='login-button']";
    static String alertmsg = "//h3[@data-test='error']";

    static ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata/Book1.xlsx");


    public static void enterusername(String Username)
    {
        List<String> user_names = excelUtils.readExcelData("Sheet1" , "Username");
        Username = user_names.get(0);
        BrowserUtils.Entertext(txtusername , Username);
    }

    public static void enterpassword(String Password)
    {
        List<String> passwords = excelUtils.readExcelData("Sheet1" , "Password");
        Password = passwords.get(0);
        BrowserUtils.Entertext(txtpassword , Password);
    }

    public static void enterlogin()
    {
        BrowserUtils.clickElement(txtlogin);
    }

    public static void validateInvalidLogin(String unexpectedness)
    {
        BrowserUtils.validateText(alertmsg, unexpectedness);
    }

    public static List<String> getUsernames() {
        return excelUtils.readExcelData("Sheet1", "Username");
    }

    public static List<String> getPasswords() {
        return excelUtils.readExcelData("Sheet1", "Password");
    }


}
