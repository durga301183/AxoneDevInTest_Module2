import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/*
Notice that simply adding WebDriverManager.chromedriver().setup(); WebDriverManager does magic for you:
It checks the version of the browser installed in your machine (e.g. Chrome, Firefox).
It checks the version of the driver (e.g. chromedriver, geckodriver). If unknown, it uses the latest version of the driver.
It downloads the WebDriver binary if it is not present on the WebDriverManager cache (~/.m2/repository/webdriver by default).
It exports the proper WebDriver Java environment variables required by Selenium (not done when using WebDriverManager from the CLI or as a Server).
 */
public class TestHowToAutomateWebDriverBinaries {
    @Test

    public void testAutomateBinaries(){
        //to launch the chrome browser

      // WebDriverManager.chromedriver().setup();
      //  WebDriver driver = new ChromeDriver();

        WebDriverManager.firefoxdriver().version("79.0.3945.36").setup();//to execute on a particular version
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://uitest.automationtester.uk");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();


        //launch an ie
        WebDriverManager.iedriver().setup();
        //to launch ie browser ona  aepcific architechture
        WebDriverManager.iedriver().architecture(Architecture.X32).setup();


    }

}
