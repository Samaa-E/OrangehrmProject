package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/main/resources/features",
        glue = "StepDefinition",
        plugin = {"pretty", "json:target/cucumber.json"},
        tags = "@UI"
)

public class TestRunner extends AbstractTestNGCucumberTests {


}