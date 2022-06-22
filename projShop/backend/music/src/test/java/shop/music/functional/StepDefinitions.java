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
import org.junit.After;
import org.openqa.selenium.interactions.Actions;

public class StepDefinitions {
    private WebDriver driver;
    @After
    public void tearDown() {
      driver.quit();
    }

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

    @And("I Go to {string} page")
    public void iGoToPage(String page) {
        if (page.equals("Login")){
            driver.findElement(By.cssSelector(".mat-list-item:nth-child(3) > .mat-list-item-content")).click();
            {
                WebElement element = driver.findElement(By.tagName("body"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element, 0, 0).perform();
            }
        } else if (page.equals("Shopping Cart")){
            driver.findElement(By.cssSelector(".cart-btn")).click();
            driver.findElement(By.linkText("1")).click();
        }
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


    @Then("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        driver.findElement(By.id("mat-input-0")).click();
        driver.findElement(By.id("mat-input-0")).sendKeys("admin@shop.pt");
        driver.findElement(By.id("mat-input-1")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".mat-flat-button"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.id("mat-input-1")).sendKeys("password");
        driver.findElement(By.cssSelector(".mat-flat-button")).click();
    }

    @And("I fill the delivery note {string}")
    public void iFillTheDeliveryNote(String note) {
        driver.findElement(By.id("note")).click();
        driver.findElement(By.id("note")).sendKeys(note);
    }

    @And("I fill the delivery address {string}")
    public void iFillTheDeliveryAddress(String address) {
        driver.findElement(By.id("address")).sendKeys(address);
    }

    @And("I fill the delivery phone number {string}")
    public void iFillTheDeliveryPhoneNumber(String phone) {
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).sendKeys(phone);
    }

    @And("I fill the delivery name {string}")
    public void iFillTheDeliveryName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @Then("I Checkout")
    public void iCheckout() {
        driver.findElement(By.cssSelector("button:nth-child(6)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("button:nth-child(6)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
    }

    @And("I add some products to my shopping cart")
    public void iAddSomeProductsToMyShoppingCart() {
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(1) .button:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(2) .button:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(3) .button:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(4) .button:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(4) .button:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(3) .button:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(2) .button:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".mat-grid-tile:nth-child(1) .button:nth-child(3)")).click();
    }

    @And("I delete some products from the Cart")
    public void iDeleteSomeProductsFromTheCart() {
        driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(2) .btn")).click();
        driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(5) .fas")).click();
        driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(5) .fas")).click();
        driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(5) .fas")).click();
        driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(4) .fas")).click();
    }

    @Then("I empty the cart")
    public void iEmptyTheCart() {
        driver.findElement(By.cssSelector("td:nth-child(2) > .btn")).click();
    }
}