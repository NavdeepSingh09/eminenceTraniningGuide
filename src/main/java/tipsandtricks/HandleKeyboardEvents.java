/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package tipsandtricks;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HandleKeyboardEvents extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        keyboardEvents();
        chainingKeyboardEvents();
        tearDown(driver);
    }

    private static void keyboardEvents() throws InterruptedException {
        Actions actions = new Actions(driver);
// Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Eminence Automation Training Centre");
//Enter the Email
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("info@eminenceautomationlabs.com");
// Enter the Current Address
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("50 Cutters Crescent Brampton");
// Select the Current Address using CMD + A
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("a");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();
// Copy the Current Address using CMD + C
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("c");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();
//Press the TAB Key to Switch Focus to Permanent Address
//        actions.sendKeys(Keys.TAB);
//        actions.build().perform();
        //Compare Text of current Address and Permanent Address
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
//Paste the Address in the Permanent Address field using CMD + V
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("v");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();
        assertEquals(currentAddress.getAttribute("value"), permanentAddress.getAttribute("value"));
        Thread.sleep(3000);
    }

    private static void chainingKeyboardEvents() throws InterruptedException {
        Actions actions = new Actions(driver);
        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Eminence Automation Training Centre");

        //Enter the Email
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("info@eminenceautomationlabs.com");

        // Enter the Current Address
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));

        currentAddress.sendKeys("50 Cutters Crescent Brampton");
        // Select the Current Address
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).build().perform();

        // Copy the Current Address
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).build().perform();

        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB).build().perform();

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();

        //Paste the Address in the Permanent Address field
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build().perform();
        assertEquals(currentAddress.getAttribute("value"), permanentAddress.getAttribute("value"));
        Thread.sleep(3000);
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
