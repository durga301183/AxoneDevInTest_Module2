package uk.axone.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestHowToTakeScreenshots {

    WebDriver driver;

   @BeforeTest

    public void openBrower(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

@Test
     public void testTakingScreenshots() throws IOException {

       driver.get("https://www.amazon.co.uk/");
       /*
        (TakesScreenshot) driver) -standalone interface and no interaction with webdriver interface
        called typecast operator .data type can be any promitive or object
        we are sayignthat treat the driver as take screenshot
 */
     //1.capture the screeshot and store it in a  temporary file
         File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         //String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
         //http://commons.apache.org/proper/commons-io/javadocs/api-2.5/org/apache/commons/io/FileUtils.html -to deaL WITH ANY IO OPERATIONS

       //2.storing in a temp by using apache commom utils but the path is hardcoded
    //running the test will create the screenshot which is visible

         FileUtils.copyFile(srcFile,
                 new File("C:/Users/G S Sastry/Axone Workspace/screenshots_synchronisation/src/test/java/temp/amazon.png"));

   }

   //to work on any machine we use relative path

@AfterTest

    public void tearDown(){
       driver.close();
}
}
