package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/r0s0q3t/Desktop/CucumberTest/APIAutomation/src/test/java/features"
        ,glue={"stepdefinitions"}
)

public class TestRunner {

}