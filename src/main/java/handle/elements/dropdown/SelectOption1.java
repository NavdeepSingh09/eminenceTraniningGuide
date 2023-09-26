/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package handle.elements.dropdown;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SelectOption1 extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        selectByIndex();
        selectByValue();
        selectByVisibleText();
        tearDown(driver);
    }

    private static void selectByIndex() throws InterruptedException {
        // Create object of the Select class
        Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
        // Select the option by index
        se.selectByIndex(3);
    }

    private static void selectByValue() throws InterruptedException {
        // Create object of the Select class
        Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
        // Select the option with value "5"
        se.selectByValue("red");
    }

    private static void selectByVisibleText() throws InterruptedException {
        Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
        // Select the option using the visible text
        se.selectByVisibleText("White");
    }

    private static void tearDown(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
