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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleDatePickers extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://www.aircanada.com/ca/en/aco/home.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        handleDate(driver);
        tearDown(driver);
    }

    private static void handleDate(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//input[@aria-label='Departure']")).click();
        Thread.sleep(2000);
        Date d = new Date(1);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");//  there are many patterns of the date are available, you can try different one at home
        String date = formatter.format(d);
        String splitter[] = date.split("-");
        String month_year = splitter[1];
        String day = splitter[0];
        System.out.println(month_year);
        System.out.println(day);
        selectDate(month_year, day);
        Thread.sleep(3000);

    }

    public static void selectDate(String month_year, String select_day) throws InterruptedException {
        do{
            driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
        }while(!driver.findElement(By.xpath("(//table[@class='abc-calendar-month ng-star-inserted']/caption)[2]")).getText().contains(month_year));

        // click on day
        List<WebElement> element=driver.findElements(By.xpath("(//table[@class='abc-calendar-month ng-star-inserted']/caption)[2]/following::div[@class='date']"));
        for(int i=0;i<element.size();i++){
            if(element.get(i).getText().equals(select_day)){
                element.get(i).click();
                break;
            }
        }



    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
