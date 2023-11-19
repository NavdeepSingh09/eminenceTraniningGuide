/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package tipsandtricks;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Scrolling extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.aircanada.com/ca/en/aco/home.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
//        scrollMethodsByPixelsDown();
//        scrollMethodsByPixelsUp();
//        scrollUntilElementVisible();
//        scrollBottomOfPage();
        smoothScrollBottomOfPage();
        tearDown();
    }

    private static void scrollMethodsByPixelsDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
    }

    private static void scrollMethodsByPixelsUp() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(2000);
    }

    private static void scrollUntilElementVisible() throws InterruptedException {
        //Locating element by xpath and store in variable "Element"
        WebElement Element = driver.findElement(By.xpath("//div[@class='ngx-ac-footer-copyright ng-star-inserted']"));

        // Scrolling down the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Element);
        Thread.sleep(2000);
    }

    private static void scrollBottomOfPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    private static void smoothScrollBottomOfPage(){
        //Locating element by xpath and store in variable "Element"
        WebElement Element = driver.findElement(By.xpath("//div[@class='ngx-ac-footer-copyright ng-star-inserted']"));

        // Scrolling down the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: \"smooth\", block: \"end\", inline: \"nearest\" });", Element);
    }

    private static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
