package com.qascript.StepDefs;

import com.qascript.PageObjects.HomePage;
import com.qascript.PageObjects.ProductsPage;
import com.qascript.PageObjects.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class ProductsStepDefs
{
    private static String FirstName="//input[@id='first-name']";
    private static String LastName="//input[@id='last-name']";
    private static String ZipCode="//input[@id='postal-code']";

    @Given("User clicks on the Product sort container link")
    public void userClicksOnTheProductSortContainerLink()
    {
        HomePage.ClickProduct();
    }

    @And("User clicks on the Add to cart button for Sauce Labs Bike Light")
    public void userClicksOnTheAddToCartButtonForSauceLabsBikeLight()
    {
        ProductsPage.AddtoCartProduct();
    }

    @When("User clicks the shoppingcart link")
    public void userClicksTheShoppingcartLink()
    {
        HomePage.ClickshopCartLink();
    }

    @Then("Sauce Labs Bike Light is added to the shopping cart")
    public void sauceLabsBikeLightIsAddedToTheShoppingCart()
    {
        ShoppingCartPage.validateLinkProduct("Sauce Labs Bike Light");
        ShoppingCartPage.validateLinkPrice("$9.99");
        ShoppingCartPage.validateLinkQuantity("1");


    }

    @And("Checkout And Enter the details to finish")
    public void checkoutAndEnterTheDetailsToFinish()
    {
        ShoppingCartPage.clickcheckout();
        ShoppingCartPage.enterInfo("Ram","kumar", "625601");
        ShoppingCartPage.clickContinue();
        ShoppingCartPage.clickFinish();
    }
}
