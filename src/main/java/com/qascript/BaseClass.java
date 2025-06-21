package com.qascript;

import com.qascript.Utils.BrowserFactory;
import com.qascript.Utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    static Properties properties = PropertiesUtil.loadApplicationProperties();
    static Properties properties1 = PropertiesUtil.loadFrameworkProperties();

    public static void InitializeDriver() {
        String url = properties.getProperty("application.url");
        String browser = properties1.getProperty("browser.driver");
        driver = BrowserFactory.getDriver(browser);
        driver.get(url);
    }

    public static void CloseDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
