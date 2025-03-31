/**
 * @author: Navdeep
 * Date: 2023-12-10
 * Time: 10:24 a.m.
 */
package webdriver.api.commands;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TryCatch extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        tryCatchTwo();
//        tryCatchThree();
//        tearDown(driver);
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }

    private boolean tryCatch() {
        try {
            if (driver.findElement(By.xpath("//p[@class='mt-3']")).isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private static boolean tryCatchOne() {
        try {
            if (driver.findElement(By.xpath("//p[@class='mt-3']")).isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch(Exception e){
            return false;
        }
    }

    private static void  tryCatchTwo () {
        try {
            int ar[] = { 1, 2 };
            for (int i = 0; i <= 7; i++)
                System.out.println(ar[i]);
            Thread.sleep(2000);
        } catch(NoSuchElementException e){

        } catch(ArrayIndexOutOfBoundsException e){

        }
        catch(InterruptedException e){

        }
        System.out.println("trueeee");

    }

    private static void tryCatchThree() throws ArrayIndexOutOfBoundsException, InterruptedException {
        int ar[] = {1, 2};
        for (int i = 0; i <= 7; i++) {
            System.out.println(ar[i]);
                Thread.sleep(2000);
        }
        System.out.println("trueeee");

    }

}
