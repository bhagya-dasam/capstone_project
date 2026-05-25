package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions", "utils"},
    plugin = {
        "pretty",
        "html:reports/cucumber-html-report",
        "json:reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true
//    tags = "@req"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}