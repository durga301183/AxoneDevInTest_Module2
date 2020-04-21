package Assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestQuestion6 {
    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://uitest.automationtester.uk/");
    }


    @Test
    public void validateRadioButton() throws InterruptedException {

        WebElement inputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        inputForms.click();
        WebElement radiobutton = driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Radio Buttons Demo')]"));
        radiobutton.click();
        Thread.sleep(2000);
        List<WebElement> radioBut = driver.findElements(By.name("ageGroup"));
        for (WebElement element : radioBut) {
            System.out.println("Age group:" + element.getAttribute("value")+" " + element.isSelected());
            if(element.getAttribute("value").equalsIgnoreCase("5-15")){
                driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
                WebElement actualAgeGroup = driver.findElement(By.xpath("//div[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]/text()[2]"));
                    actualAgeGroup.getText();
                Assert.assertEquals(actualAgeGroup, "5-15");
            }
        }

    }

    @AfterTest

public void tearDown(){
        driver.quit();
    }
}
