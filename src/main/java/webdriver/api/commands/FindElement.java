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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElement extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.eminenceautomationlabs.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        findElement();
        findElements();
        tearDown(driver);
    }

    private static void findElement() {
        String dropdownName = driver.findElement(By.xpath("(//a[@id='collasible-nav-dropdown'])[1]")).getText();
        System.out.println("Name of Dropdown = " + dropdownName);
    }

    private static void findElements() {
        List<WebElement> listElement = driver.findElements(By.xpath("(//a[@id='collasible-nav-dropdown'])"));
        for (int i = 0; i < listElement.size(); i++) {
            System.out.println("List view dropdown name = " + listElement.get(i).getText());
        }
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
