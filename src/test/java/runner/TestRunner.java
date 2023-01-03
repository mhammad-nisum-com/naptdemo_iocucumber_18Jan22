package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="features/",
        glue={"com.nisum"},
        tags = {"@DemoSite"},
        plugin={"pretty", "html:target/Destination", "json:target/cucumber.json"}
)

public class TestRunner{

}
