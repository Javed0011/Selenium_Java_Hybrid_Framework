package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/Features",
		glue="StepDefinition",
		plugin = {
			        "pretty",
			        "html:target/CucumberReports/CucumberReport.html",
			        "json:target/CucumberReports/report.json",
			        "junit:target/CucumberReports/report.xml"
			    }
		)
public class runner extends AbstractTestNGCucumberTests{

}
