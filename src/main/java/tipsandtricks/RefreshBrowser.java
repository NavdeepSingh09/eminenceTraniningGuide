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

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RefreshBrowser extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.toolsqa.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        refreshPage();
        tearDown(driver);
    }

    private static void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@class='navbar__search--input']")).sendKeys(Keys.F5);//works for windows
        driver.get(driver.getCurrentUrl());
        driver.navigate().to(driver.getCurrentUrl());
        driver.findElement(By.xpath("//input[@class='navbar__search--input']")).sendKeys("\uE035");//works for windows
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
