package uk.axone.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHowToHandleWebTables {
    WebDriver driver;

    @BeforeTest

    public void setupBrowser()  {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.londonstockexchange.com/exchange/prices-and-markets/stocks/risers-and-fallers/risers-fallers.html");

    }
@Test
   public void testhandlingTables() throws InterruptedException {
        Thread.sleep(3000);
      List<WebElement> stockname = driver.findElements(By.xpath("//table[1]/tbody/tr/td[2]"));
      List<WebElement> price = driver.findElements(By.xpath("//table[1]/tbody/tr/td[3]"));

       //iterating two lists

       for(int i=0; i<stockname.size();i++){

           System.out.println("stockname: "+stockname.get(i).getText() + " and the price is "+price.get(i).getText());
       }
   // individual coolumn
   // for (WebElement element1 : stockname) {
        //System.out.println(element1.getText());

    }


@AfterTest
public void tearDownBrowser(){
        driver.quit();
}

}
