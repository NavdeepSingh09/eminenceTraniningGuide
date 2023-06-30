/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package tipsandtricks;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HandleMouseEvents extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/slider/"); //  https://demoqa.com/menu/
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //moveCursorMiddleOfElement();
        moveCursorOffset();
        tearDown(driver);
    }

    private static void moveCursorMiddleOfElement() throws InterruptedException {
        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement 'Main Item 2' to perform mouse hover
        WebElement menuOption = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        //Mouse hover menuOption 'Main Item 2''
        actions.moveToElement(menuOption).perform();
        System.out.println("Done Mouse hover on 'Main Item 2' from Menu");

        //Now Select 'SUB SUB LIST »'' from sub menu which has got displayed on mouse hover of 'Music’
        WebElement subMenuOption = driver.findElement(By.xpath(".//a[contains(text(),'SUB SUB LIST »')]"));
        //Mouse hover menuOption 'SUB SUB LIST »''
        actions.moveToElement(subMenuOption).perform();
        System.out.println("Done Mouse hover on 'Rock' from Menu");
        //Now , finally, it displays the desired menu list from which required option needs to be selected //Now Select 'Sub Sub Item 1' from sub menu which has got displayed on mouse hover of 'SUB SUB LIST »'’
        WebElement selectMenuOption = driver.findElement(By.xpath(".//a[contains(text(),'Sub Sub Item 1')]"));
        selectMenuOption.click();
        System.out.println("Selected 'Sub Sub Item 1' from Menu");

    }

    private static void moveCursorOffset(){
        Actions actions = new Actions(driver);
        //Retrieve WebElemnt 'slider' to perform mouse hover
        WebElement slider = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
        //Move mouse to x offset 50 i.e. in horizontal direction
        actions.moveToElement(slider,50,0).perform();
        slider.click();
        System.out.println("Moved slider in horizontal directions");
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
