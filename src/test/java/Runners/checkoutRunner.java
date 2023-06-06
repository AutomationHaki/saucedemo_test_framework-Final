package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Checkout.feature",
        glue = {"stepDefs"},
        plugin = { "pretty", "html:target/Checkout-reports.html" },
        monochrome = true
)
public class checkoutRunner extends AbstractTestNGCucumberTests {
}
