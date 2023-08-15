/**
 * @author: Navdeep
 * Date: 2023-07-27
 * Time: 5:19 p.m.
 */
package run.first.test.cloud;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

public class FirstSimpleTest {
    static RemoteWebDriver driver = null;
    String username = new String(Base64.getDecoder().decode("Y2hlZW1zLm5hdmk="));
    String accesskey = new String(Base64.getDecoder().decode("b1pSZlBzNUhORzM0R2pRMkVBRVlkN0RaejBnUlI4aDJ3cXRYa09zR3dmQkVMU216UTQ="));
    String gridURL = "@hub.lambdatest.com/wd/hub";

    public static void main(String[] args) {

        new FirstSimpleTest().setUp();
//        System.setProperty("webdriver.chrome.driver","/Users/sukhdeep/Desktop/IT/Chrome/chromedriver");
//        WebDriver driver = new ChromeDriver();
        driver.get("https://skillupautomation.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
        driver.quit();
    }
    @Test
    public void execute(){
        new FirstSimpleTest().setUp();
        driver.get("https://skillupautomation.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
        driver.quit();
    }

    private void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("build", "BrowserTest");
        capabilities.setCapability("name", "SkillUpAutomation");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
