package uk.axone.managingcontrols;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// textbox is for reading, typing and clearing values
public class TestHowToHandleTextBox {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

@Test
public void testMnaagerBox() throws InterruptedException {

        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
      WebElement txtusermsg=  driver.findElement(By.id("user-message"));
      txtusermsg.sendKeys("xyz");
      Thread.sleep(3000);
      txtusermsg.clear();
    System.out.println(txtusermsg.getAttribute("value"));
      Thread.sleep(3000);
    //gettext is the visible text but attribute is the value of the webelement
}

@AfterTest

    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
}











}
