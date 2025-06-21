package com.qascript.PageObjects;

import com.qascript.Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qascript.BaseClass.driver;

public class ProductsPage
{
    private static String bikelightlink = "(//div[@class='inventory_item_name '])[2]";
    private static String btnAddtoCart = "//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//button";

    public static void clickrightProduct()
    {
        BrowserUtils.clickElement(bikelightlink);
    }

    public static void AddtoCartProduct()
    {
        BrowserUtils.clickElement(btnAddtoCart);
    }

}
