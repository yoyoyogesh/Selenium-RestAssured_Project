import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/CreateUser.feature",
        glue = {"stepdefinition"},
        tags = {"@APIAutomation"},
        plugin = {"pretty","html:target/cucumber-options"},
        monochrome = true
)

public class TestRunner {
}
