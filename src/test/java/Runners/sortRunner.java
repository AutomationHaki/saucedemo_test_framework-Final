package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/ItemSort.feature",
        glue = {"stepDefs"},
        plugin = { "pretty", "html:target/ItemSort-reports.html" },
        monochrome = true
)
public class sortRunner extends AbstractTestNGCucumberTests {
}
