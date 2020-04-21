package uk.axone.advancedtestNG;

import org.testng.annotations.Test;

public class TestHowToCreateDependencies  {

//creatign end to end or  integration tests so its fine to write dependant tests
    @Test
    public void launchWebSite(){
        System.out.println("Opening website");
    }

    @Test(dependsOnMethods = {"launchWebSite"})
    public void loginWebsite(){
        System.out.println("Login to website");
    }

    @Test(dependsOnMethods = {"launchWebSite", "loginWebsite"})
    public void addToShoppingCartTest(){
        System.out.println("Begin -   cart Test");
       try{
           int x = 100;
        System.out.println(x / 0);} catch (Exception e) {
           e.printStackTrace();
       }
        System.out.println("End -  cart Test");
}

    @Test(dependsOnMethods = "addToShoppingCartTest")
    public void checkOutTest(){
        System.out.println("Checkout Test");
    }


}





