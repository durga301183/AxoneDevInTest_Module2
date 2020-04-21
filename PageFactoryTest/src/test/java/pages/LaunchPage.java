package pages;

public class LaunchPage extends BasePage {
    public LaunchPage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateToHomePage(final String urlToNavigate){
        driver.get(urlToNavigate);
        return PageFactory.initElements(driver, HomePage.class);
    }
}
