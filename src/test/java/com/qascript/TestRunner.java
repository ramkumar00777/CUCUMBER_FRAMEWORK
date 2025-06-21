package com.qascript;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:feature/ShoppingCart.feature", // ✅ works in Jenkins
        glue = "com.qascript.StepDefs",                      // ✅ correct package notation
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json"
        },
        publish = true
)
public class TestRunner { }
