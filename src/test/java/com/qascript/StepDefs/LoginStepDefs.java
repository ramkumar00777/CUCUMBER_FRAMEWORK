package com.qascript.StepDefs;

import com.qascript.BaseClass;
import com.qascript.PageObjects.HomePage;
import com.qascript.PageObjects.LoginPage;
import com.qascript.Utils.PropertiesUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginStepDefs extends BaseClass {

    WebDriver driver = Hooks.driver;

    Properties properties = PropertiesUtil.loadApplicationProperties();
    Properties properties1 = PropertiesUtil.loadUserProperties();

    @Given("user enters valid username in the email field")
    public void enterValidUsername()
    {
        String username = properties1.getProperty("user-name");
        LoginPage.enterusername(username);
    }

    @And("user enters valid password in the password field")
    public void enterValidPassword()
    {
        String password = properties1.getProperty("password");
        LoginPage.enterpassword(password);
    }

    @When("user clicks on the login button")
    public void clickLogin()
    {
        String login = properties.getProperty("login");
        LoginPage.enterlogin();
    }

    @Then("user is logged in successfully")
    public void loginSuccess()
    {
        HomePage.validate("Products");
    }

    /* ---------- Negative scenario ---------- */

    @Given("user enters invalid username in the email field")
    public void enterInvalidUsername(String username)
    {
        LoginPage.enterusername(username);
    }

    @And("user enters invalid password in the password field")
    public void enterInvalidPassword(String password)
    {
        LoginPage.enterpassword(password);
    }

    @Then("error message is displayed")
    public void errorDisplayed(String message)
    {
       LoginPage.validateInvalidLogin(message);
    }

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication()
    {
        enterValidUsername();
        enterValidPassword();
        clickLogin();
        loginSuccess();
    }




}
