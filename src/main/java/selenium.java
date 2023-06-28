import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class selenium {




    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/sukhdeep/Desktop/Chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");//http://codeshre.io/MN9jAn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();

        driver.findElement(By.id("userName-label")).isDisplayed();
        driver.findElement(By.name("userName")).sendKeys("Automation");
        driver.findElement(By.className("form-label")).getText();
        driver.findElement(By.cssSelector("input[id='userName’]")).sendKeys("Automation");
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.partialLinkText("ome")).click();
        driver.findElement(By.tagName("input")).isDisplayed();

        //Thread.sleep(10000);
        System.out.println();

        try{
            driver.findElement(By.xpath("//*[contains(text(),'CLOSE')]")).click();

        }catch(Exception ignored){

        }
        driver.findElement(By.xpath("//*[contains(text(),'Sort and Tables')]")).click();
        Select drop=new Select(driver.findElement(By.name("tablepress-2_length")));
        drop.selectByValue("25");
        Thread.sleep(5000);
        int even=driver.findElements(By.className("column-1")).size();
        /*ArrayList<String> list_name = new ArrayList<String>();
        for(int i=0;i<even;i++){
            list_name.add(driver.findElements(By.className("column-1")).get(i).getText());
        }
        Collections.sort(list_name);
        System.out.println("List==="+list_name);*/
        //*[contains(text(),'first_name')]
        driver.findElement(By.xpath("//*[contains(text(),'first_name')]")).click();
        System.out.println("Name===== "+driver.findElements(By.className("column-8")).get(1).getText());
        if(driver.findElements(By.className("column-8")).get(1).getText().contains("65")){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        driver.close();
        
    }

}
