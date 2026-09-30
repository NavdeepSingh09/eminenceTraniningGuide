/**
 * @author: Navdeep
 * Date: 2024-09-11
 * Time: 1:40 p.m.
 */
package youtube;

import common.CommonConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.time.Duration;

class IncognitoModeChrome extends CommonConfig {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        // System.setProperty("webdriver.chrome.driver", chromePath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        tearDown(driver);
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
