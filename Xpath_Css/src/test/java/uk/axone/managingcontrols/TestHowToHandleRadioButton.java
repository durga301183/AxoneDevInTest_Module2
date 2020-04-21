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

public class TestHowToHandleRadioButton {
    WebDriver driver;

    @BeforeTest
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
@Test
    public void testManageRadioButton() throws InterruptedException {
        driver.get("http://uitest.automationtester.uk/basic-radiobutton-demo.html");
      List<WebElement> webele =  driver.findElements(By.name("optradio"));
       webele.get(1).click();
       for(WebElement radio:webele){
          //returns boolean
           System.out.println(radio.getAttribute("value") + "Is selected?: " + radio.isSelected());
       }

  // WebElement ele =  driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input"));
  // ele.getAttribute("Male");

   //ele.click();
                 Thread.sleep(3000);
    }
    @AfterTest
    public void tearDownBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
