package org.pranav.cucumber.testAutomation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
glue="org.pranav.cucumber.testAutomation.stepDefs",
features="src/test/java"
		)
public class RunCucumberTest {
}