/**
 * @author: Navdeep
 * Date: 2024-09-02
 * Time: 2:55 p.m.
 */
package youtube;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class IsDisplayed extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Is this element displayed = "+isDisplayed_checkBox());
        System.out.println("My execution continue");
        tearDown(driver);
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
    }

    private static boolean isDisplayed_checkBox() throws InterruptedException {
        return isDisplayed(By.xpath("//h1[@class='text-center']"), true);
    }

    private static boolean isDisplayed(By by){
        return isDisplayed(by, false);
    }

    private static boolean isDisplayed( By by, boolean silent){
        if(silent){
            try{
                return driver.findElement(by).isDisplayed();
            } catch(NoSuchElementException e){
                return false;
            }
        } else{
            return driver.findElement(by).isDisplayed();
        }

    }

}
