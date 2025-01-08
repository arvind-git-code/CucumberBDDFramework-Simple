package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags="@smoke",
        features = "src/test/resources/features/", // Path to your feature files
        glue = {"stepDefinition"},					
        plugin= {"pretty","html:target/htmlReport.html"})  // Package containing your step definitions
public class TestRunner extends AbstractTestNGCucumberTests{

}
