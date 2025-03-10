/**
 * @author: Navdeep
 * Date: 2024-09-11
 * Time: 1:40 p.m.
 */
package youtube;

import common.CommonConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WindowsMacDriverSelection extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        setupWebDriver();
        driver.get("https://skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        tearDown(driver);
    }

    private static String getOperatingSystem(){
        return System.getProperty("os.name").toLowerCase();
    }

    private static void setupWebDriver() throws IOException {
        String os = getOperatingSystem().toLowerCase();
        String chromeDriverPath = "";
        switch (os) {
            case "windows":
                chromeDriverPath = "D:\\Browser Binaries\\chromedriver_win32\\chromedriver.exe";
                System.out.println("Windows Chrome driver selected");
                break;
            case "mac":
                chromeDriverPath = chromePath();
                System.out.println("Macbook Chrome driver selected");
                break;
            default:
                System.out.println("Operating system not found");
                return;
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
