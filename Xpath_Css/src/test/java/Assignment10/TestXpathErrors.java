package Assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestXpathErrors {

    WebDriver driver;

        @BeforeTest
        public void setUpBrowser(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }


        @Test
        public void testXpathErrors() throws InterruptedException {
            driver.get("http://seleniumpractice.axone-tech.uk/");
            System.out.println(driver.findElement(By.xpath("//img[@class='logo img-responsive'")).getAttribute("src"));
            Thread.sleep(5000);

        }

        @AfterTest
        public void tearDownBrowser(){
            driver.quit();
        }
    }


