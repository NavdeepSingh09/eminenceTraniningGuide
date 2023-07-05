/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package tipsandtricks;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RightDoubleClick extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        rightClickPage();
        doubleClickPage();
        tearDown(driver);
    }

    private static void rightClickPage() throws InterruptedException {
        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform right click
        WebElement btnElement = driver.findElement(By.id("rightClickBtn"));

        //Right Click the button to display Context Menu&nbsp;
        actions.contextClick(btnElement).perform();
        System.out.println("Right click Context Menu displayed");
    }

    private static void doubleClickPage() throws InterruptedException {
        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform double click WebElement
        WebElement btnElement = driver.findElement(By.id("doubleClickBtn"));

        //Double Click the button
        actions.doubleClick(btnElement).perform();

        System.out.println("Button is double clicked");
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
