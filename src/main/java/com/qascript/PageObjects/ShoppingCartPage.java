package com.qascript.PageObjects;

import com.qascript.Utils.BrowserUtils;

public class ShoppingCartPage {

    private static String Checkout = "//button[@id='checkout']";
    private static String LinkProduct = "//div[contains(@class, 'inventory_item_name') and contains(text(), 'Sauce Labs Bike Light')]";
    private static String LinkQuantity = "//div[@class=\"cart_quantity\"][1]";
    private static String LinkPrice = "(//div[@class=\"inventory_item_price\"])[1]";
    private static String FirstName = "//input[@id='first-name']";
    private static String LastName = "//input[@id='last-name']";
    private static String ZipCode = "//input[@id='postal-code']";
    private static String Nextpart ="//input[@id='continue']";
    private static String Finish ="//button[@id='finish']";


    public static void clickcheckout() {
        BrowserUtils.clickElement(Checkout);
    }

    public static void clickContinue()
    {
        BrowserUtils.clickElement(Nextpart);
    }

    public static void clickFinish()
    {
        BrowserUtils.clickElement(Finish);
    }

    public static void validateLinkProduct(String expectedtext) {
        BrowserUtils.validateText(LinkProduct, expectedtext);
    }

    public static void validateLinkQuantity(String expectedtext) {
        BrowserUtils.validateText(LinkQuantity, expectedtext);
    }

    public static void validateLinkPrice(String expectedtext) {
        BrowserUtils.validateText(LinkPrice, expectedtext);
    }

    public static void enterInfo(String fname, String lname, String zip) {
        BrowserUtils.Entertext(FirstName, fname);
        BrowserUtils.Entertext(LastName, lname);
        BrowserUtils.Entertext(ZipCode, zip);
    }


}
