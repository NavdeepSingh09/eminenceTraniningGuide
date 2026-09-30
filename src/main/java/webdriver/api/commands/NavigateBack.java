/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package webdriver.api.commands;

import common.CommonConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class NavigateBack extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

//        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        navigateBack();
        tearDown(driver);
    }

    private static void navigateBack() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/text-box");
        driver.navigate().back();
        Thread.sleep(5000);
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
