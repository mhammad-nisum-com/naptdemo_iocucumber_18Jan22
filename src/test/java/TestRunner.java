import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * The UI Test runner
 */

@CucumberOptions(
		features = "features/ebay",
        glue = {"com.napt.eBay.steps"},
        tags = {"@AddToCart"},
        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json", "junit:target/cucumber.xml","rerun:target/failed_scenarios.txt"})
public class TestRunner extends AbstractTestNGCucumberTests {

}

