package uk.axone.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TestFullScreenshot_Advanced {

    WebDriver driver;
        @BeforeTest
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        @Test
        public void testTakingScreenshots() throws IOException {
            driver.get("https://www.amazon.co.uk/");
//https://github.com/pazone/ashot
            Screenshot screenshot= new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
//write to a location
            ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir")+"/src/test/java/temp/FullScreenshot.png"));
        }

        @AfterTest

        public void tearDown() {
            driver.quit();
        }

    }



