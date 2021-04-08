package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/Features"
,glue= {"TpgStepDefinitions"}
,tags= {"@selectPGWandEnterDetails"}
)
public class testRunner {

}
