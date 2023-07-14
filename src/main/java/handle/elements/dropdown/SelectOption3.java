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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectOption3 extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        deselectAll();
        deselectByIndex();
//        deselectByValue(); //value is not available in DOM
        deselectByVisibleText();
        tearDown(driver);
    }

    private static void deselectAll() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("cars")));
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Saab");
        select.deselectAll();
    }

    private static void deselectByIndex() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("cars")));
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Saab");
        select.deselectByIndex(0);
    }

    //Value is not available in DOM
    private static void deselectByValue() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("cars")));
        select.deselectByValue("1");
    }

    private static void deselectByVisibleText() {
        Select select = new Select(driver.findElement(By.id("cars")));
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Saab");
        select.deselectByVisibleText("Volvo");
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
