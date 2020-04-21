package Assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestQuestion7 {

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
        public void selectButton() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".tree-branch>ul>li:first-of-type"))).click();
            //driver.findElement(By.cssSelector()).click();
            List<WebElement> list = driver.findElements(By.cssSelector(".tree-branch>ul>li:nth-of-type(1) :nth-child(4)"));
           // Thread.sleep(3000);
            for (WebElement element : list) {
                System.out.println(element.getText());
                if (element.getText().equalsIgnoreCase("Select Dropdown List")) {
                    element.click();
                    Thread.sleep(3000);
                }

            }

        }

       @Test

       public void selectingOptions() throws InterruptedException {

           WebElement ele = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[1]"));
           System.out.println( ele.getText());
           WebElement multiSelect = driver.findElement(By.id("multi-select"));
           Select states = new Select(multiSelect);
        //   System.out.println("is this a Multi select ddl: "+states.isMultiple());
           List<WebElement> listOfStates = states.getOptions();
           for (WebElement webElement : listOfStates) {
               if (webElement.getText().equalsIgnoreCase("California") || webElement.getText().equalsIgnoreCase("Pennsylvania")) {
                   webElement.click();
               }
               Thread.sleep(1000);
               driver.findElement(By.xpath("//*[@id='printMe']")).click();
              // Thread.sleep(1000);
               driver.findElement(By.xpath("//*[@id='printAll']")).click();
           }
       }

        @AfterTest

    public void tearDown(){
        driver.quit();
    }
}

