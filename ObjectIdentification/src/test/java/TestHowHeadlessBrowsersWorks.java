import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.html.Html;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class TestHowHeadlessBrowsersWorks {

    //https://github.com/SeleniumHQ/htmlunit-driver

    @Test

    public void headlessBrowsersWorks(){

        WebDriver driver = new HtmlUnitDriver(BrowserVersion.BEST_SUPPORTED);
         driver.navigate().to("http://uitest.automationtester.uk");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }


}
