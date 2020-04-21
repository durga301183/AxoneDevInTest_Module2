import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ObjectIdentification {



    /**
     * @author Karthik.Gandhinathan
     */
    public class TestHowObjectIdentificationWorks {

        WebDriver driver;

        @BeforeTest
        public void setUpBrowser(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @Test
        public void testObjectId() throws InterruptedException {
            driver.get("http://seleniumpractice.axone-tech.uk/");
            Thread.sleep(5000);
            //1. Identifying the target WebElement
            WebElement searchQueryTopTxtBox = driver.findElement(By.id("search_query_top"));
            //2. command to execute
            searchQueryTopTxtBox.sendKeys("Searching some value...");
            Thread.sleep(5000);
            searchQueryTopTxtBox.clear();
            Thread.sleep(5000);
            searchQueryTopTxtBox.sendKeys("Search again...");
            System.out.println("Value present :"+searchQueryTopTxtBox.getAttribute("value"));

        }

        @AfterTest
        public void tearDownBrowser(){
            driver.close();
        }
    }







}
