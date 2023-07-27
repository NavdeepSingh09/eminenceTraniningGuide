/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package live.project;

import common.CommonConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ExerciseSolution extends CommonConfig {
    static WebDriver driver;
    static Double totalItemPrice;
    static Double priceItem1;
    static Double priceItem2;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        verifyLoginPageErrorMessage();
        loginWithCredentials();
        addItemToCart();
        verifyPriceInCartAndSelectCheckout();
        fillCheckoutInfo();
        checkoutOverview();
        verifyCompleteThankYouMessage();
        tearDown(driver);
    }

    private static void verifyLoginPageErrorMessage(){
        loginButton().click();
        assertTrue(errorMessageLoginPage().getText().contains("Username is required"));
    }

    private static void loginWithCredentials() {
        username().sendKeys("standard_user");
        password().sendKeys("secret_sauce");
        loginButton().click();
    }

    private static double priceItem(WebElement itemLocator) {
        String price = itemLocator.getText();
        String splitPrice = price.replaceAll("\\$", "");
        return Double.parseDouble(splitPrice);
    }

    private static double taxDouble(WebElement itemLocator) {
        String price = itemLocator.getText();
        String[] splitPrice = price.split("\\$");
        return Double.parseDouble(splitPrice[1]);
    }

    private static void addItemToCart() {
        assertTrue(isAtProductListScreen().isDisplayed());
        priceItem1 = priceItem(priceBackpack());
        priceItem2 = priceItem(priceFleeceJacket());
        totalItemPrice = priceItem1 + priceItem2;
        addToCartSauceLabsBackpack().click();
        addToCartSauceLabsFleeceJacket().click();
        assertTrue(removeSauceLabsBackpack().isDisplayed());
        assertTrue(removeSauceLabsFleeceJacket().isDisplayed());
        cart().click();
    }

    private static void verifyPriceInCartAndSelectCheckout() {
        assertTrue(priceBackpackCart().getText().contains(String.valueOf(priceItem1)));
        assertTrue(priceFleeceJacketCart().getText().contains(String.valueOf(priceItem2)));
        checkout().click();
    }

    private static void fillCheckoutInfo() {
        assertTrue(isAtCheckoutUserInformation().isDisplayed());
        firstName().sendKeys("myFirstName");
        lastName().sendKeys("myLastName");
        postalCode().sendKeys("123456");
        buttonContinue().click();
    }

    private static void checkoutOverview() {
        DecimalFormat df = new DecimalFormat("0.00");
        assertTrue(isAtCheckoutOverview().isDisplayed());
        assertTrue(subTotal().getText().contains(String.valueOf(totalItemPrice)));
        assertTrue(total().getText().contains(String.valueOf(df.format(taxDouble(tax()) + totalItemPrice))));
        finish().click();
    }

    private static void verifyCompleteThankYouMessage() {
        assertTrue(isAtCheckoutComplete().isDisplayed());
        Assert.assertEquals("Thank you for your order!", thankYouMessage().getText());
        buttonBackHome().click();
        assertTrue(isAtProductListScreen().isDisplayed());
    }

    private static WebElement loginButton() {
        return driver.findElement(By.id("login-button"));
    }

    private static WebElement errorMessageLoginPage() {
        return driver.findElement(By.xpath("//h3"));
    }

    private static WebElement username() {
        return driver.findElement(By.id("user-name"));
    }

    private static WebElement password() {
        return driver.findElement(By.id("password"));
    }

    private static WebElement isAtProductListScreen() {
        return driver.findElement(By.xpath("//span[@class='title' and text()='Products']"));
    }

    private static WebElement addToCartSauceLabsBackpack() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    private static WebElement addToCartSauceLabsFleeceJacket() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
    }

    private static WebElement priceBackpack() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']/preceding::div[@class='inventory_item_price']"));
    }

    private static WebElement priceFleeceJacket() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']/preceding-sibling::div[@class='inventory_item_price']"));
    }

    private static WebElement removeSauceLabsBackpack() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    private static WebElement removeSauceLabsFleeceJacket() {
        return driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));
    }

    private static WebElement cart() {
        return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    }

    private static WebElement priceBackpackCart() {
        return driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']/preceding-sibling::div[@class='inventory_item_price']"));
    }

    private static WebElement priceFleeceJacketCart() {
        return driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']/preceding-sibling::div[@class='inventory_item_price']"));
    }

    private static WebElement checkout() {
        return driver.findElement(By.id("checkout"));
    }

    private static WebElement firstName() {
        return driver.findElement(By.id("first-name"));
    }

    private static WebElement lastName() {
        return driver.findElement(By.id("last-name"));
    }

    private static WebElement postalCode() {
        return driver.findElement(By.id("postal-code"));
    }

    private static WebElement buttonContinue() {
        return driver.findElement(By.id("continue"));
    }

    private static WebElement isAtCheckoutUserInformation() {
        return driver.findElement(By.xpath("//span[@class='title' and text()='Checkout: Your Information']"));
    }

    private static WebElement isAtCheckoutOverview() {
        return driver.findElement(By.xpath("//span[@class='title' and text()='Checkout: Overview']"));
    }

    private static WebElement subTotal() {
        return driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
    }

    private static WebElement tax() {
        return driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
    }

    private static WebElement total() {
        return driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
    }

    private static WebElement finish() {
        return driver.findElement(By.id("finish"));
    }

    private static WebElement isAtCheckoutComplete() {
        return driver.findElement(By.xpath("//span[@class='title' and text()='Checkout: Complete!']"));
    }

    private static WebElement thankYouMessage() {
        return driver.findElement(By.xpath("//h2[@class='complete-header']"));
    }

    private static WebElement buttonBackHome() {
        return driver.findElement(By.id("back-to-products"));
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
