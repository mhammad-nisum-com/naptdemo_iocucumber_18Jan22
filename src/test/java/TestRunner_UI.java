import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * The UI Test runner
 */

@CucumberOptions(
        features = "features",
        glue = {"com.napt.ui.safeway.steps"},
        tags = {"@test"},
        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json", "rerun:target/failed_scenarios.txt"})
public class TestRunner_UI extends AbstractTestNGCucumberTests {

}

