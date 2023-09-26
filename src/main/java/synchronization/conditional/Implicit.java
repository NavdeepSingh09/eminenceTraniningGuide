/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package synchronization.conditional;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Implicit extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        // Implicit wait declaration
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Is this element enabled = "+isEnabled());
        tearDown(driver);
    }

    private static boolean isEnabled() throws InterruptedException {
        try {
            if (driver.findElement(By.xpath("//p[@class='mt-3']")).isEnabled()) {
                return true;
            } else {
                return false;
            }
        }catch(NoSuchElementException e){
            return false;
        }
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
