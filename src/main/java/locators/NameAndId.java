/**
 * @author: Navdeep
 * Date: 2023-06-06
 * Time: 9:32 p.m.
 */
package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NameAndId {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/sukhdeep/Desktop/IT/Chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");//http://codeshre.io/MN9jAn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
        boolean inputTag= driver.findElement(By.tagName("iput")).isDisplayed();
        System.out.println("Boolean value ="+inputTag);
        driver.close();
    }


}
