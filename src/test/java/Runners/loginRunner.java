package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/Login.feature",
        glue = {"stepDefs"},
        plugin = { "pretty", "html:target/Login-reports.html" },
        monochrome = true
)
public class loginRunner extends AbstractTestNGCucumberTests {

}
