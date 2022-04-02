package restAPI.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)    // we want to run our test using Cucumber
@CucumberOptions(
        plugin = {"pretty"}, // one of the way how we put out the information in the console
        features = {"src/test/resources/features"},
        glue = {"restAPI/stepdefinitions"} // holding everything together - step is linked with the method

)

public class TestRunner {

}
