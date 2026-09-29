package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps {
	WebDriver driver;

    @Given("user launches website")
    public void launchWebsite() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username and password")
    public void enterCredentials() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user clicks login button")
    public void clickLogin() {

        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should see products page")
    public void verifyLogin() {

        String url = driver.getCurrentUrl();

        if(url.contains("inventory")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }

        driver.quit();
    }
}
