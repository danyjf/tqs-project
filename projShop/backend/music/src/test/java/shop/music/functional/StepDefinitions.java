package shop.music.functional;

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

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.hamcrest.MatcherAssert.assertThat;


public class StepDefinitions {
    private WebDriver driver;

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        //options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1053));
    }

    @And("I Select the Product I Want")
    public void iSelectTheProductIWant() {
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(1) .button")).click();
    }
    @And("I Click {string} button")
    public void iClickButton(String arg0) {
        driver.findElement(By.cssSelector(".cart-btn")).click();
    }
    @And("I click {string}")
    public void iClick(String text) {
        driver.findElement(By.linkText(text)).click();
    }

    @And("I create new account with user {string}, fullname {string}, email {string}, password {string}")
    public void iCreateNewAccountWithUserFullnameEmailPassword(String username, String fullname, String email, String password) {
        driver.findElement(By.id("mat-input-0")).click();
        driver.findElement(By.id("mat-input-0")).sendKeys(username);
        driver.findElement(By.id("mat-input-1")).sendKeys(fullname);
        driver.findElement(By.id("mat-input-2")).sendKeys(email);
        driver.findElement(By.id("mat-input-3")).sendKeys(password);
        driver.findElement(By.cssSelector(".mat-flat-button > .mat-button-wrapper")).click();
    }

    @And("I confirm buy for address {string}")
    public void iConfirmBuyForAddress(String address) {
        assertThat(driver.switchTo().alert().getText(), is("Are you sure you want to buy this product?"));
        driver.switchTo().alert().accept();
        assertThat(driver.switchTo().alert().getText(), is("Please enter the delivery address: "));
        {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(address);
            alert.accept();
        }
    }
}