package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {
//standalone page as the top menu repeats and can be seen in every page
    @FindBy(xpath = "//a[@class='logout']")
     private WebElement lnkSignout;

    public WebDriver driver;
//with the basepage constructor initialise the topmenu
    public TopMenuPage(WebDriver driver){
        this.driver =driver;
    }
    //clicking on logout page gives you login page .Here we didnt extend  the class with Basetest which is because when we land on a ny page
    // signout is the common element and if we lan on any page and wants to sign out we can do it
    public LoginPage Logout(){
        lnkSignout.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
