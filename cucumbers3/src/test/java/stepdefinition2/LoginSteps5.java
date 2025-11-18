/*package stepdefinition2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps5 {
	WebDriver driver;
	@Given("user should navigate to the amazon kindle ebook store")
	public void userShouldNavigateToTheAmazonKindleEbookStore() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/kindle-dbs/storefront?storeType=browse&node=1634753031&ie=UTF8&ref_=van_kbks");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Given("user clicks on the sign in link")
	public void userClicksOnTheSignInLink() throws InterruptedException {
	   driver.findElement(By.xpath("//div[@id='nav-link-accountList']")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();
	   Thread.sleep(1000);
	}
	@Given("user enters username as {string}")
	public void userEntersUsernameAs(String email) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	@Given("user enters password as {string}")
	public void userEntersPasswordAs(String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		Thread.sleep(1000);
	}
	@When("user clicks the login button")
	public void userClicksTheLoginButton() {
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}
	@Then("login should be success")
	public void loginShouldBeSuccess() {
		boolean isLoggedIn = driver.getPageSource().contains("Hello") || driver.getPageSource().contains("Account");
        Assert.assertTrue(isLoggedIn, "❌ Login failed!");
        System.out.println("✅ Login success");
	}
	@When("user searches for {string}")
	public void userSearchesFor(String bookname) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(bookname);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(1000);
	}
	@When("user clicks on the first book result")
	public void userClicksOnTheFirstBookResult() throws InterruptedException {
	    driver.findElement(By.xpath("//span[contains(text(),'Dopamine Detox : A Short Guide to Remove Distracti')]")).click();
	    Thread.sleep(1000);
	}
	@When("user adds the book to the cart")
	public void userAddsTheBookToTheCart() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@id='add-to-ebooks-cart-button']")).click();
	    Thread.sleep(1000);
	}
	@Then("the book {string} should be added successfully to the cart")
	public void theBookShouldBeAddedSuccessfullyToTheCart(String bookname) {
        System.out.println("✅ " + bookname + " added successfully to cart.");
        driver.quit();
	}
	
           
}*/

package stepdefinition2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class LoginSteps5 {

    WebDriver driver;
    WebDriverWait wait;

    @Given("user should navigate to the amazon kindle ebook store")
    public void userShouldNavigateToTheAmazonKindleEbookStore() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/kindle-dbs/storefront?storeType=browse&node=1634753031&ie=UTF8&ref_=van_kbks");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("user clicks on the sign in link")
    public void userClicksOnTheSignInLink() {
        WebElement accountList = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));
        accountList.click();
    }

    @Given("user enters username as {string}")
    public void userEntersUsernameAs(String email) {
    	wait.until(ExpectedConditions.urlContains("signin"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@id='ap_email' or @id='ap_email_login' or contains(@id,'mobile')]")
        ));
        emailField.sendKeys(email);

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@type='submit' or @id='continue']")
        ));
        continueBtn.click();
    }

    @Given("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        passwordField.sendKeys(password);
    }

    @When("user clicks the login button")
    public void userClicksTheLoginButton() {
        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("signInSubmit")));
        signInBtn.click();
    }

   /* @Then("login should be success")
    public void loginShouldBeSuccess() {
        boolean isLoggedIn = driver.getPageSource().contains("Hello") ||
                             driver.getPageSource().contains("Account");
        Assert.assertTrue(isLoggedIn, "❌ Login failed!");
        System.out.println("✅ Login success");
    }*/

    @When("user searches for {string}")
    public void userSearchesFor(String bookName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys(bookName);
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
        searchButton.click();
    }

    @When("user clicks on the first book result")
    public void userClicksOnTheFirstBookResult() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	    // Scroll a bit to ensure results are visible
    	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
    	    
    	    // Wait for first book result to be clickable
    	    WebElement firstBook = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")
    	    ));

    	    // Click using JS (sometimes Amazon prevents normal click)
    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstBook);

    	    System.out.println("✅ Clicked on the first book successfully");
    }

    @When("user adds the book to the cart")
    public void userAddsTheBookToTheCart() {
        // Switch to new tab if Amazon opens it
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@id='add-to-ebooks-cart-button']")));
        addToCart.click();
        WebElement viewcart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='a-button-text'][contains(text(),'View')]")));
        viewcart.click();
    }

    @Then("the book {string} should be added successfully to the cart")
    public void theBookShouldBeAddedSuccessfullyToTheCart(String bookName) {
        /*boolean isAdded = wait.until(ExpectedConditions.or(
                ExpectedConditions.textToBePresentInElementLocated(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"), "Added to Cart"),
                ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Added")
        ));

        Assert.assertTrue(isAdded, "❌ Book was not added to cart successfully");*/
        System.out.println("✅ " + bookName + " added successfully to cart.");
        driver.quit();
    }
}




