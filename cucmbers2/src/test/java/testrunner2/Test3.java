package testrunner2;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
@CucumberOptions(
    features = "src/test/java/features",
    dryRun =! true,
    glue = {"stepdefinition2","hooks"} ,
    plugin = {"pretty","html:target/cucumber-reports/html-report",
            "json:target/cucumber-reports/cucumber.json",
            "junit:target/cucumber-reports/cucumber.xml"},
    tags = "@smoke",
    snippets = SnippetType.CAMELCASE,
    monochrome = true
)
public class Test3 extends AbstractTestNGCucumberTests {
}
