package uk.axone.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHowToHandleAlerts {
    WebDriver driver;

    @BeforeTest

    public void setupBrowser()  {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/javascript-alert-box-demo.html");

    }

    @Test

    public void TestAlerts() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(), 'click for Prompt Box')]")).click();
//explicit wait
            WebDriverWait wait =  new WebDriverWait(driver, 10);
       Alert alert=  wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());
            Thread.sleep(3000);
            alert.accept();
            alert.dismiss();
            alert.sendKeys("Hello Alert Box");
            Thread.sleep(3000);


        }
        public void tearDown(){
        driver.quit();
        }
    }

