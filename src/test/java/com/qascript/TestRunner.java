package com.qascript;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature/ShoppingCart.feature"},// Path to .feature file
        glue = {"com/qascript/StepDefs"},
        plugin =
                {
                        "pretty",
                        "html:target/cucumber-reports.html" ,
                        "json:target/cucumber-reports.json"
                },

        publish = true

)
public class TestRunner
{

}
