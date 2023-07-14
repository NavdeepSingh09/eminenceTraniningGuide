/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package handle.elements.alerts;

import common.CommonConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PromptAlert extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        promptAlerts();
        tearDown(driver);
    }

    private static void promptAlerts() throws InterruptedException {
        WebElement element = driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is: " + alertText);
        //Send some text to the alert
        promptAlert.sendKeys("Test User");// Somehow Sendkeys is not working
        promptAlert.accept();

    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
