package com.qascript.PageObjects;

import com.qascript.BaseClass;
import com.qascript.Utils.BrowserUtils;

public class HomePage extends BaseClass
{

    private static String LinkProductSortContainer = "//select[ @class='product_sort_container']//option[3]";
    private static String Linkforshoppingcart = "//a[@class='shopping_cart_link']";

    public static void validate(String expectedtext)
    {
        String check = "//span[@class='title']";
        BrowserUtils.validateText(check, expectedtext);
    }

    public static void ClickProduct()
    {
        BrowserUtils.clickElement(LinkProductSortContainer);
    }

    public static void ClickshopCartLink()
    {
        BrowserUtils.clickElement(Linkforshoppingcart);
    }
}
