/**
 * @author: Navdeep
 * Date: 2024-09-04
 * Time: 9:34 p.m.
 */
package youtube;

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
//        isSelected_radioBox();
//        selectRadioButton();
        unselectRadioButton();
        tearDown(driver);
    }

    private static void isSelected_radioBox() throws InterruptedException {
        WebElement radioElement = driver.findElement(By.id("impressiveRadio"));
        System.out.println("Is Selected = " + radioElement.isSelected());

        //click on element by using javascript Executor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", radioElement);
        System.out.println("Is Selected = " + radioElement.isSelected());
    }

    private static void selectRadioButton(){
        WebElement radioElement = driver.findElement(By.id("impressiveRadio"));
        if(!radioElement.isSelected()){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", radioElement);
        }
    }

    private static void unselectRadioButton(){
        WebElement radioElement = driver.findElement(By.id("impressiveRadio"));
        if(radioElement.isSelected()){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", radioElement);
        }
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
