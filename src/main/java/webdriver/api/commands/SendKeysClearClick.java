/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package webdriver.api.commands;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SendKeysClearClick extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://skillupautomation.com/register/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        sendKeysClearClick();
        tearDown(driver);
    }

    private static void sendKeysClearClick() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='g114-name']")).sendKeys("Automation Course");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='g114-name']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Send']")).click();
        Thread.sleep(3000);
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
