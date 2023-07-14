/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package handle.elements;

import common.CommonConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Frames extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        switchFramesIndex();
        switchFramesNameId();
        switchFramesWebElement();
        tearDown(driver);
    }

    //Index is not working right now with frame selection
    private static void switchFramesIndex() throws InterruptedException {
        driver.switchTo().frame(0);
        WebElement frame1Heading = driver.findElement(By.id("sampleHeading"));
        //Finding the text of the heading
        String frame1Text = frame1Heading.getText();
        System.out.println("Get text using index: " + frame1Text);
    }

    private static void switchFramesNameId() throws InterruptedException {
//      Switch to Frame using id of the frame
        driver.switchTo().frame("frame1");
        WebElement frame1Heading = driver.findElement(By.id("sampleHeading"));
        String frame1Text = frame1Heading.getText();
//        Print the heading text
        System.out.println("Get text using Name/Id: " + frame1Text);
        driver.switchTo().defaultContent();
    }

    private static void switchFramesWebElement() throws InterruptedException {
        WebElement frame1 = driver.findElement(By.id("frame1"));
//      Switching the WebDriver context to frame1
        driver.switchTo().frame(frame1);
//      Identifying the frame heading in a WebElement
        WebElement frame1Heading = driver.findElement(By.id("sampleHeading"));
//      Finding the text of the frame1 heading
        String frame1Text = frame1Heading.getText();
//      Print the heading
        System.out.println("Get text using webElement:" + frame1Text);

//      Switching back to Main Page
        driver.switchTo().defaultContent();
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
