/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package tipsandtricks;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Headless extends CommonConfig {

    public static void main(String[] args) throws IOException, InterruptedException {
        HeadlessDefaultBrowser();
//        HeadlessChrome();
    }

    private static void HeadlessDefaultBrowser(){

        // Declaring and initialising the HtmlUnitWebDriver
//        HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        HtmlUnitDriver unitDriver=new HtmlUnitDriver(BrowserVersion.CHROME,true);

        // open demo site webpage
        unitDriver.get("https://www.eminenceautomationlabs.com/");

        //Print the title of the page
        System.out.println("Title of the page is -> " + unitDriver.getTitle());
        unitDriver.close();
    }

    private static void HeadlessChrome() throws IOException {
        //declare the chrome driver from the local machine location
        System.setProperty("webdriver.chrome.driver", chromePath());

        //create object of chrome options
        ChromeOptions options = new ChromeOptions();

        //add the headless argument
        options.addArguments("headless");

        //pass the options parameter in the Chrome driver declaration
        WebDriver driver = new ChromeDriver(options);

        //Navigate to Eminence site url
        driver.get("https://www.eminenceautomationlabs.com/");

        //Print the Title of the Page
        System.out.println("Title of the page is -> " + driver.getTitle());

        //Close the driver
        driver.close();
    }


}
