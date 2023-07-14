/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 2:55 p.m.
 */
package handle.elements.dropdown;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectOption2 extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        getOptions();
        getFirstSelectedOption();
        getSelectedOptions();
        tearDown(driver);
    }

    private static void getOptions() throws InterruptedException {
        Select select = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
        // Get all the options of the dropdown
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        //simplify for loop
        for (int i = 0; i < options.size(); i++) {
            System.out.println("Simplify for loop result: " + options.get(i).getText());
        }
    }

    private static void getFirstSelectedOption() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("cars")));
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Saab");
        // Get the first selected option of the dropdown
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("First Selected Option= " + firstSelectedOption.getText());
    }

    private static void getSelectedOptions() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("cars")));
        // Get all the selected option of the dropdown
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            System.out.println("Selected Options: " + option.getText());
        }
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
