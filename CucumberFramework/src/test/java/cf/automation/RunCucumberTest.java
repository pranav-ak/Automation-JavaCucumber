package cf.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
glue="src/test/java",
features="src/test/java/features"
		)
public class RunCucumberTest {
}