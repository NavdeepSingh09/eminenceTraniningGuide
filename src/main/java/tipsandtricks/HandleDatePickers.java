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
        driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        handleDate(driver);
        tearDown(driver);
    }

    private static void handleDate(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("datetimepicker1")).click();//select first date
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
            driver.findElement(By.xpath("(//span[@class='flatpickr-next-month'])[1]")).click(); // click on next month
        }while(!driver.findElement(By.xpath("(//div[@class='dayContainer'])[1]/span[@class='flatpickr-day']")).getAttribute("aria-label").contains(month_year));

        // click on day
        List<WebElement> element=driver.findElements(By.xpath("(//div[@class='dayContainer'])[1]/span[@class='flatpickr-day']"));// select day here
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
