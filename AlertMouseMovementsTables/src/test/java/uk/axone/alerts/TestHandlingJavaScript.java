package uk.axone.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHandlingJavaScript {
//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/JavascriptExecutor.html
    WebDriver driver;

    @BeforeTest

    public void setupBrowser()  {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/javascript-alert-box-demo.html");

    }

    @Test
    public void testJavaScript() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js= (JavascriptExecutor) driver;

        //1.refresh the browser
        js.executeScript("history.go(0)");
        Thread.sleep(3000);
        //2.scrolling
        //x and y coordinates. x won't change always zero and y alone changes (x,y) by some pixels
        js.executeScript("window.scrollBy(0,1000");
        //to print the title
        System.out.println(js.executeScript("return document.title"));

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
