package testrunner3;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
@CucumberOptions(
		features={"src/test/java/features/login.feature"},
		dryRun = !true,
		glue="stepdefinition2",
		snippets = SnippetType.CAMELCASE
		)

public class Test4 extends AbstractTestNGCucumberTests {
}
