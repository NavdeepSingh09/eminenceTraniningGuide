/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package webdriver.api.commands;

import common.CommonConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class CloseQuit extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

//        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        openNewTab();
        tearDown(driver);
    }

    private static void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");

        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.get("https://demoqa.com/text-box");
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
        driver.quit();
    }
}
