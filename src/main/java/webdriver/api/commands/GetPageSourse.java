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

public class GetPageSourse extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        // System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.eminenceautomationlabs.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println("Page source =\n " + getPageSource());
        tearDown(driver);
    }

    private static String getPageSource() throws InterruptedException {
        return driver.getPageSource();
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
