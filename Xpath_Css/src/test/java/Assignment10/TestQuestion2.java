package Assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 *
 * 1) Follow the steps:
 * a) Go to https://www.bbc.co.uk/
 * b) Using CSS Selector locator strategy fetch the linktexts available in the home page top Menu.
 * c) Fetch all the HREFs for the linktexts and then print them.
 *
 */
public class TestQuestion2 {

    WebDriver driver;

    @BeforeTest

    public void setupBrowser() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.co.uk");

    }

    @Test
    public void getlinktextfromBBC() {

        // Finding all elemenst on the top bar which are under anchor tag

        List<WebElement> allLinks = driver.findElements(By.cssSelector("a"));
        //finding the total number of links
        System.out.println("total number of links in the BBC page:" + allLinks.size());
        for (WebElement element : allLinks) {
            System.out.println(element.getText());
            System.out.println(element.getAttribute("href"));

            //for(int i=0; i<allLinks.size();i++){

            //System.out.println(allLinks.get(i).getText());

        }

    }


    @AfterTest
    public void closeBrowser() throws InterruptedException {
        //close the application after the test is finished

            Thread.sleep(3000);
            driver.quit();


        }

    }












