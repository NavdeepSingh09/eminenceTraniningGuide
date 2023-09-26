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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DynamicTables extends CommonConfig {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nyse.com/ipo-center/ipo-pricing-stats");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        checkDynamicTable(driver);
        tearDown(driver);
    }

    private static void checkDynamicTable(WebDriver driver) {
        // Find Number oÒf Columns
        List<WebElement> columnsNumber = driver.findElements(By.xpath("//table//tbody//tr"));
        System.out.println("Number of Columns = " + columnsNumber.size());

        // Find Number of Rows
        List<WebElement> rowsNumber = driver.findElements(By.xpath("//table//tbody//tr/td"));
        System.out.println("Number of Rows = " + rowsNumber.size());

        // Find HealthCare get text

        String name = driver.findElement(By.xpath("//table//tbody//tr[3]/td[1]")).getText();
        System.out.println("Name of the text = " + name);

        for (int c = 0; c < columnsNumber.size(); c++) {
            System.out.println("Number of C = " + columnsNumber.get(c).getText());
            if (columnsNumber.get(c).getText().contains("Consumer Services")) {
                List<WebElement> rowsNumber1 = driver.findElements(By.xpath("//table//tbody//tr[" + (c + 1) + "]/td"));
                System.out.println("Number of R = " + rowsNumber1.size());
                for (int r = 0; r < rowsNumber1.size(); r++) {
                    WebElement ele = driver.findElement(By.xpath("//table//tbody//tr[" + (c + 1) + "]/td[" + (r + 1) + "]"));
                    String value = ele.getText();
                    System.out.println(" Consumer Services numbers " + value);
                }
            }
        }
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
