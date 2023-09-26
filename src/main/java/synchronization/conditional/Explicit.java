/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package synchronization.conditional;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Explicit extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        // Implicit wait declaration
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        explicitWait();
        tearDown(driver);
    }

    private static void explicitWait() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println("Explicit wait here for maximum 10 second to visible of element");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mt-3']")));
//        driver.findElement(By.xpath("//p[@class='mt-3']")).isEnabled();
        System.out.println("Explicit wait is over");
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
