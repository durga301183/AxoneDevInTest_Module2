package uk.axone.managingcontrols;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHowToManageDropdownList {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testManageRadioButton() throws InterruptedException {
        driver.get("http://uitest.automationtester.uk/basic-select-dropdown-demo.html");
        Thread.sleep(3000);
        //1.selecting the webelement
        WebElement webele = driver.findElement(By.id("select-demo"));
        //to select values
        webele.sendKeys("Tuesday");
        //3.to read the values present in the dropdown list
        //solution1
       List<WebElement> daylist = webele.findElements(By.tagName("option"));
        for (WebElement days : daylist) {
          //  System.out.println(days.getText());
        }
            //solution2
        Select days = new Select(webele);
        //days.selectByVisibleText("Thursday");
        //days.getAllSelectedOptions();
        days.selectByIndex(0);
        days.selectByIndex(2);
       List<WebElement>  dayslist = days.getOptions();
        for (WebElement day2 : dayslist) {
            System.out.println(day2.getText());

        }
    }
    @AfterTest
    public void tearDownBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
