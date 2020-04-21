package uk.axone.xpathandcss;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 * @project DEC_DIT_M2_TestNGBasics
 */
public class TestHowToUseXpathIdentification {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void testXpath() throws InterruptedException {
        driver.get("http://seleniumpractice.axone-tech.uk/");
        System.out.println(driver.findElement(By.xpath("html/body/div/div/header/div[3]/div/div/div/a/img")).getAttribute("src"));
        System.out.println(driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getAttribute("src"));
        Thread.sleep(5000);

    }

    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }
}
