package base;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.TopMenuPage;

//Base page is implemented as every time driver is initiated which is implemented here
public class BasePage {
    public WebDriver driver;
    private TopMenuPage topMenu;
//constructor
    public BasePage(WebDriver driver){
        this. driver = driver;
//this.driver is the instance variable driver and the driver on the RHS is the parameter passed
        topMenu = PageFactory.initElements(driver, TopMenuPage.class);

    }
}
