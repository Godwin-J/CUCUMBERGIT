package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks{
@Before
public void beforescenario(Scenario scenario) {
	String name=scenario.getName();
	System.out.println("name--"+name);
}
@After
public void afterscenario(Scenario scenario) {
	boolean failed=scenario.isFailed();
	System.out.println("failed--"+failed);
}
}
