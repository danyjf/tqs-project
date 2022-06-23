package pt.ua.tqs.backend.Functional;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;


public class StepDefinitions {
    private WebDriver driver;

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1053));
    }

    @Then("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/div[1]/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/div[1]/input")).sendKeys(email);
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/div[2]/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/div[2]/input")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/div[3]/button")).click();
    }
}
