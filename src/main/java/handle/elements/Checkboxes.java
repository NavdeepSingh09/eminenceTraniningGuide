/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package handle.elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Checkboxes extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        selectCheckBoxBestPractise();
        Thread.sleep(10000);
        tearDown(driver);
    }

    private static void selectCheckBoxBestPractise() throws InterruptedException {
        WebElement checkBoxElement = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        if(!checkBoxElement.isSelected()){
            //checkBoxElement.click();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", checkBoxElement);
        }
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
