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

public class BrowserSwitchBack extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        handleMultipleBrowser();
        tearDown(driver);
    }

    private static void handleMultipleBrowser() throws InterruptedException {
        driver.findElement(By.id("windowButton")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is: " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }

        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainWindow);
        System.out.println("Button text is :"+driver.findElement(By.xpath("//button[@id='tabButton']")).getText());
    }

    private static void tearDown(WebDriver driver) {
        driver.quit();
    }
}
