package uk.axone.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MyStepdefs {
    WebDriver driver;
    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @When("user clicks on sign-in link")
    public void userClicksOnSignInLink() {
        driver.findElement(By.xpath("//a[@class='login']")).click();

    }

    //scrolling in page

    public void scrollInPage () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(500,1000)");
        Thread.sleep(2000);

    }

    @And("user enters the mail as {string}")
    public void userEntersTheMailAs(String mail) {
        driver.findElement(By.id("email")).sendKeys(mail);
    }

    @And("user enters the code as {string}")
    public void userEntersTheCodeAs(String code) {
        driver.findElement(By.id("passwd")).sendKeys(code);
    }

    @When("user clicks on the Signin button")
    public void userClicksOnTheSigninButton() throws InterruptedException {
        driver.findElement(By.name("SubmitLogin")).click();
        Thread.sleep(2000);


    }

    @Then("user should see the Header as {string}")
    public void userShouldSeeTheHeaderAs(String expected) {

        String actual =null;
        System.out.println("expected is:" + expected);
        actual = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
        System.out.println("actual is:"+ actual);
        Assert.assertEquals(actual,expected);
    }

    @When("user click on logout")
    public void userClickOnLogout() throws InterruptedException {
        driver.findElement(By.className("logout")).click();
        Thread.sleep(2000);
    }

    @Then("user should see the Header page with  {string}")
    public void userShouldSeeTheHeaderWas(String exp) {
        String act =null;
        System.out.println(exp);
        act = driver.findElement(By.className("login")).getText();
        System.out.println(act);
        Assert.assertEquals(act,exp);

    }

    @And("user quits the browser")
    public void userQuitsTheBrowser() {
        driver.quit();
    }
}
