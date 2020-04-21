package Assignment11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Question1_HandlingWebTables {

    WebDriver driver;
    @BeforeTest
    public void setupBrowser()  {
        WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src =gain_lose");

        }


      public void companyNamesAndTables() throws InterruptedException {

            Thread.sleep(3000);

           List<WebElement> companynames = driver.findElements(By.xpath("//table[1]/tbody/tr/td[1]"));
          List<WebElement> prices = driver.findElements(By.xpath("//table[1]/tbody/tr/td[4]"));

          for(int i=0; i<=companynames.size()-5; i++){
              System.out.println(companynames.get(i).getText() + " " + prices.get(i).getText());
              System.out.println(companynames.size());
          }

                  int output = getRowWithCellText("Heritage Foods");
          System.out.println("Heritage Foods is found at row number" + output);

        }


@Test
   private int  getRowWithCellText(String input) {
/*
     get the row size
     get the col size
     loop through rows remember to start from tr[1] and fetch the td in each row
      loop through each cell of a row
 */
int x=0;
       int rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
    //   int cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
    for (int rowNum = 1; rowNum <= rows; rowNum++) {
           // get all the cells
           List<WebElement> rowCells = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[" + rowNum + "]/td"));
           // compare each cell data with the passed in input
           if (rowCells.get(0).getText().trim().equalsIgnoreCase(input)) {
               // if it matches return the row number and break the routine
               System.out.println( x=rowNum);
               break;
           }
       }
    return x;
    }

       @AfterTest
    public void tearDownBrowser(){
        driver.quit();

    }

}




