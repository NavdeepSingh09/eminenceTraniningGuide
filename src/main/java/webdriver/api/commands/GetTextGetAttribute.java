/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package webdriver.api.commands;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GetTextGetAttribute extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.eminenceautomationlabs.com/discover#contactus");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        getTextGetAttribute();
        tearDown(driver);
    }

    private static void getTextGetAttribute() throws InterruptedException {
        String textName = driver.findElement(By.xpath("(//label[@class='amplify-label'])[1]")).getText();
        System.out.println("Label Text = " + textName);
        Thread.sleep(3000);
        String placeHolderName = driver.findElement(By.xpath("//textarea")).getAttribute("placeholder");
        System.out.println("Placeholder Name = " + placeHolderName);
        Thread.sleep(3000);
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
