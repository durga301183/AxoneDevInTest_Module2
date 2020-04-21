package uk.axone.managingcontrols;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHandlingPortionOfAWebpage {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testdynamicwebpage() throws InterruptedException {

        driver.get("http://shopping.rediff.com/?sc_cid=ushome_icon");

        //1.first to identify the whole box
        WebElement popularCat = driver.findElement(By.id("popular_cat"));
        //2.to identify all the webelements init
        List<WebElement> catlist= popularCat.findElements(By.tagName("a"));

   //solution1
      //  for(WebElement ele:catlist) {
      // System.out.println(ele.getText());

 //  }


        //solution2

        String element1 = "//div[@id=\"popular_cat\"]/h3[";
        String element2 = "]/a";
        for(int i=1; i<=catlist.size();i++){

          // System.out.println(driver.findElement(By.xpath(element1 + i + element2)).getText());

        }
        Thread.sleep(2000);

        //sloution 3
        // div[@id="popular_cat"]/h3/a find element under h3 tag ending with a
   }

   @AfterTest
    public void teardown() throws InterruptedException {
        driver.quit();
    }

}


