import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * The Rerun Test runner
 */

@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = {"com.nisum.napt.projects.demo.uiecomdemo"},
        plugin = {"pretty", "html:target/cucumber_target_rerun.html", "json:target/cucumber_rerun.json", "rerun:target/failed_scenarios.txt"})
public class TestRunnerRerun extends AbstractTestNGCucumberTests {

}

