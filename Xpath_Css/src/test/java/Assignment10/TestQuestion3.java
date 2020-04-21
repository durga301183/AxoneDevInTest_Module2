package Assignment10;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.TimeUnit;

public class TestQuestion3 {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.zoho.com/");
    }

      @Test
       public void customisedXpath() throws InterruptedException {
        driver.findElement(By.xpath("//a[starts-with(@class,'zh-login')]")).click();
        WebElement login= driver.findElement(By.xpath("//input[starts-with(@id,'login_id')]"));
        login.sendKeys("test@axone.com");
        String text = login.getAttribute("value");
        System.out.println("value is"+text);
        Assert.assertEquals("test@axone.com", text);

    }

    @AfterTest
    public void tearDownBrowser() throws InterruptedException {
     Thread.sleep(2000);
        driver.quit();
    }
}






