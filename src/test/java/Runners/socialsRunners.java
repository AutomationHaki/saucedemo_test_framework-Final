package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Socials.feature",
        glue = {"stepDefs"},
        plugin = { "pretty", "html:target/Socials-reports.html" },
        monochrome = true
)
public class socialsRunners extends AbstractTestNGCucumberTests {
}
