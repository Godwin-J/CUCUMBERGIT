package stepdefinition2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps4 {
    WebDriver driver;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    
   @Then("user should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        if (driver.getCurrentUrl().contains("dashboard")) {
            System.out.println("✅ Login successful");
        } else {
            System.out.println("❌ Login failed");
        }
        driver.quit();
    }
    
    @But("user should not redirected to dashboard")
    public void userShouldNotRedirectedToDashboard() {
    	if (driver.getCurrentUrl().contains("dashboard")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
        driver.quit();
    }
}

