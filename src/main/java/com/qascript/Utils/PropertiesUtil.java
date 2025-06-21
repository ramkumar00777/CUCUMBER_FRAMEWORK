package com.qascript.Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil
{
    public static Properties loadProperties(String filePath)
    {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static Properties loadApplicationProperties()
    {
        return loadProperties("src/test/resources/config/application.properties");
    }

    public static Properties loadFrameworkProperties()
    {
        return loadProperties("src/test/resources/config/framework.properties");
    }

    public static Properties loadUserProperties()
    {
        return loadProperties("src/test/resources/config/user.properties");
    }
}
