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
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ChildBrowserHandle extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        handleChildBrowser();
        tearDown(driver);
    }

    private static void handleChildBrowser() throws InterruptedException {
//      Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();

//      Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

//      Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.manage().window().maximize();
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is: " + text.getText());
            }
        }
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
