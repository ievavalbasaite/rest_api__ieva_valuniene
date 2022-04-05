package restAPI.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)    // we want to run our test using Cucumber
@CucumberOptions(
        plugin = {"pretty", // one of the way how we put out the information in the console
                "json:target/cucumber-reports/CucumberTestReport.json", // for the jason report the plugin will look in target report (noted)
                "junit:target/cucumber-reports/report.xml" // the rest of reports will be looked on that folder
        },
        features = {"src/test/resources/features"},
        glue = {"restAPI/stepdefinitions"} // holding everything together - step is linked with the method
)

public class TestRunner {
}
