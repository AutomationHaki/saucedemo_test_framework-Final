package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/AddToCart.feature",
        glue = {"stepDefs"},
        plugin = { "pretty", "html:target/AddToCart-reports.html" },
        monochrome = true
)
public class cartRunner extends AbstractTestNGCucumberTests {

}
