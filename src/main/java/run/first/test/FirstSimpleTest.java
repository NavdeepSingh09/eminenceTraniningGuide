/**
 * @author: Navdeep
 * Date: 2023-07-27
 * Time: 5:19 p.m.
 */
package run.first.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstSimpleTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/sukhdeep/Desktop/IT/Chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://skillupautomation.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
    }
}
