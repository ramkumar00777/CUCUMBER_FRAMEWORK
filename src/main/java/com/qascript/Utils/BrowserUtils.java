package com.qascript.Utils;

import com.qascript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BrowserUtils extends BaseClass {

    static Properties properties = PropertiesUtil.loadFrameworkProperties();

    public static void clickElement(String xpath) {
        findAndWaitForElement(xpath).click();
    }

    public static void Entertext(String xpath, String text) {
        findAndWaitForElement(xpath).sendKeys(text);
    }

    public static WebElement findAndWaitForElement(String xpath) {
        String timeout = properties.getProperty("timeout.maximum");
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
            element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Element not found for xpath: " + xpath);
        }
        return element;
    }

    public static void validateText(String xpath, String expectedText) {
        String actualText = findAndWaitForElement(xpath).getText();
        if (!actualText.equals(expectedText)) {
            throw new RuntimeException("Expected: " + expectedText + " but found: " + actualText);
        }
    }







}
