/**
 * @author: Navdeep
 * Date: 2023-12-10
 * Time: 10:44 a.m.
 */
package webdriver.api.commands;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class isDisplayedExample extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {
//        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        selectRadioButton();
        tearDown(driver);
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }

    private static boolean selectRadioButton(){
        WebElement webElement = driver.findElement(By.id("impressiveRadio"));
        if(!webElement.isSelected()) {
            webElement.click();
        }
        return true;
    }


}
