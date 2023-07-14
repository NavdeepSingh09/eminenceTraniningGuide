/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package handle.elements.browsers;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserErrors extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        browserErrors();
        tearDown(driver);
    }

    private static void browserErrors() throws InterruptedException {
//      Open new window by clicking the button
        driver.findElement(By.id("windowButton")).click();

//      Click on the new window element and read the text displayed on the window
        WebElement text = driver.findElement(By.id("sampleHeading"));

//      Fetching the text using method and printing it
        System.out.println("Element found using text: " + text.getText());
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
