/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package webdriver.api.commands;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class IsSelected extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        isSelected_checkBox();
        tearDown(driver);
    }

    private static void isSelected_checkBox() throws InterruptedException {
        WebElement radioElement = driver.findElement(By.id("impressiveRadio"));
        System.out.println("Is Selected = " + radioElement.isSelected());
        //click on element by using javascript Executor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", radioElement);
        System.out.println("Is Selected = " + radioElement.isSelected());
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
