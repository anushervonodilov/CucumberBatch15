package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;

    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {

        String browserType = "Chrome";
        switch (browserType) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }
    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
    }
    @When("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.id("btnLogin")).click();
    }
    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        boolean userLoggedIn = driver.findElement(By.xpath("//a[contains(text(), 'Welcome')]")).isDisplayed();
        if (userLoggedIn) {
            System.out.println("User is logged in successfully");
        }
    }

}
