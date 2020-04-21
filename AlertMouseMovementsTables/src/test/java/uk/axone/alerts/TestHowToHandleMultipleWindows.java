package uk.axone.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
//interview querstion: how to handle multiple windows
//Ans :driver.switchto
public class TestHowToHandleMultipleWindows {

   WebDriver driver;

    @BeforeTest

    public void setupBrowser(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://mail.axone-tech.uk/useful-links");
    }

    @Test

    public void testMultipleWindows() throws InterruptedException {
        Thread.sleep(5000);
      driver.findElement(By.xpath("//h3[contains(text(),'How to use Xpath Functions')]")).click();
     //returns String as its from java.lang.string
      Set<String> windows = driver.getWindowHandles();
      //to get the size
      System.out.println(windows.size());

      //to iterate , which returns an iterator which returns of type string
        Iterator<String> itr =windows.iterator();
       //window handle is stored ins  seperate variable
        String mainwindow=   itr.next();
      String popupwindow =itr.next();
      driver.switchTo().window(popupwindow);
      System.out.println(driver.getTitle());
     //current window open will be closed
      driver.close();

      driver.switchTo().window(mainwindow);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }

    @AfterTest

    public void tearDown(){
driver.quit();
    }
}
