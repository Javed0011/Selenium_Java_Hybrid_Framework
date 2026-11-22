
package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import utilities.ExtentReporter;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentReporter.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            ExtentReporter.logScenarioFail(
                    "Scenario failed: " + scenario.getName()
            );
        }
    }

    @AfterAll
    public static void afterAll() {
        ExtentReporter.flushReport();
    }
}
