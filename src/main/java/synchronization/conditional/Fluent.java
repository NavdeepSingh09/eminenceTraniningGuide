/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package synchronization.conditional;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Fluent extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        // Implicit wait declaration
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        fluentWait();
        tearDown(driver);
    }

    private static void fluentWait() throws InterruptedException {
        // Fluent wait deceleration here
        Wait<WebDriver> fluentWait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class, TimeoutException.class);
        System.out.println("Fluent wait here for maximum 15 seconds but polling every 5 seconds until visible of element");
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mt-3']")));
        System.out.println("Fluent wait is over");
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
