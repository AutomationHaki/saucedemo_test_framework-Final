package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class stepDefinitions {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("The user is on the login page of SwagLabs")
    public void theUserIsOnTheLoginPageOfSwagLabs() {

        this.driver.get("https://www.saucedemo.com");
    }

    @When("The user enters valid credentials")
    public void theUserEntersValidCredentials() {
        WebElement usernameInput = this.driver.findElement(By.id("user-name"));
        WebElement passwordInput = this.driver.findElement(By.id("password"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
    }

    @And("The user clicks the login button")
    public void theUserClicksTheLoginButton() {
        WebElement loginButton = this.driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("The user should be taken to the Inventory page")
    public void theUserShouldBeTakenToTheInventoryPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // test - website won't show inventory.html if login is not successful
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://www.saucedemo.com/inventory.html", "login failed!");

    }
    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        this.driver.get("https://www.saucedemo.com");
        WebElement usernameInput = this.driver.findElement(By.id("user-name"));
        WebElement passwordInput = this.driver.findElement(By.id("password"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        WebElement loginButton = this.driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("The user adds the Fleece Jacket to their cart")
    public void theUserAddsTheFleeceJacketToTheirCart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        addToCartButton.click();
    }

    @And("The user navigates to their cart")
    public void theUserNavigatesToTheirCart() {
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();
    }

    @Then("The Fleece Jacket should be added to the cart")
    public void theFleeceJacketShouldBeAddedToTheCart() {
        WebElement item = driver.findElement(By.className("inventory_item_name"));
        String itemName = item.getText();
        assertEquals(itemName, "Sauce Labs Fleece Jacket", "Jacket not in cart");
    }
    @When("The user selects the low to high sort option")
    public void theUserClicksTheSortButton() {
        WebElement sort = this.driver.findElement(By.className("product_sort_container"));
        sort.click();
        Select dropdownElement = new Select(sort);
        dropdownElement.selectByValue("lohi");
    }

    @Then("The items should be sorted by price in ascending order")
    public void theItemsShouldBeSortedByPriceInAscendingOrder() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //find prices of items
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

        // get prices as strings
        List<String> priceStrings = new ArrayList<>();
        for (WebElement element : priceElements) {
            priceStrings.add(element.getText());
        }

        // convert to doubles and remove $ signs
        List<Double> prices = new ArrayList<>();
        for (String priceString : priceStrings) {
            String newPrice = priceString.replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(newPrice);
            prices.add(price);
        }

        //sort prices ascending order
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        //Test if sorted prices are equal to actual prices
        Assert.assertEquals(prices, sortedPrices);
    }
    @When("The user clicks on the twitter button")
    public void theUserClicksOnTheTwitterButton() {
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();
        WebElement twitterButton = this.driver.findElement(By.className("social_twitter"));
        twitterButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @Then("The user is directed to the company's twitter profile")
    public void theUserIsDirectedToTheCompanySTwitterProfile() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement twitterAccountName = this.driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div/div/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/span/span[1]"));
        String tName = twitterAccountName.getText();
        assertEquals(tName, "Sauce Labs", "invalid twitter link");
    }

    @When("The user clicks on the facebook button")
    public void theUserClicksOnTheFacebookButton() {
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();
        WebElement facebookButton = this.driver.findElement(By.className("social_facebook"));
        facebookButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

    }

    @Then("The user is directed to the company's facebook profile")
    public void theUserIsDirectedToTheCompanySFacebookProfile() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement facebookAccountName = this.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div/div/div/div[3]/div/div/div[1]/div/div/span/h1"));
        String fName = facebookAccountName.getText();
        assertEquals(fName, "Sauce Labs", "invalid facebook link");
    }

    @When("The user clicks on the linkedin button")
    public void theUserClicksOnTheLinkedinButton() {
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();
        WebElement linkedInButton = this.driver.findElement(By.className("social_linkedin"));
        linkedInButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @Then("The user is directed to the company's linkedin profile")
    public void theUserIsDirectedToTheCompanySLinkedinProfile() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String pageTitle = driver.getTitle();
        assertEquals(pageTitle, "Sauce Labs | LinkedIn", "invalid linkedin link");
    }
    @And("The user clicks the checkout button")
    public void theUserClicksTheCheckoutButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement checkoutButton = this.driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @Then("The user enters delivery info")
    public void theUserEntersDeliveryInfo() {
        WebElement firstName = this.driver.findElement(By.id("first-name"));
        WebElement lastName = this.driver.findElement(By.id("last-name"));
        WebElement postalCode = this.driver.findElement(By.id("postal-code"));

        firstName.sendKeys("Uzair");
        lastName.sendKeys("Khan");
        postalCode.sendKeys("7441");

        WebElement continueButton = this.driver.findElement(By.id("continue"));
        continueButton.click();
    }

    @And("Finalizes the checkout process")
    public void finalizesTheCheckoutProcess() {
        WebElement finishButton = this.driver.findElement(By.id("finish"));
        finishButton.click();

        WebElement confirmationMessage = this.driver.findElement(By.className("complete-header"));
        String checkoutComplete = confirmationMessage.getText();

        assertEquals(checkoutComplete, "Thank you for your order!", "checkout failed");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
