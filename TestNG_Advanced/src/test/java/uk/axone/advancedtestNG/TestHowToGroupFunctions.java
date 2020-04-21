package uk.axone.advancedtestNG;

import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 * @project DEC_DIT_M2_TestNGBasics
 */
public class TestHowToGroupFunctions {

    @Test(groups = {"Cart"})
    public void carTest1(){
        System.out.println("Cart Test - 1");
    }

    @Test(groups = {"Cart"})
    public void carTest2(){
        System.out.println("Cart Test - 2");
    }

    @Test(groups = {"Cart"})
    public void carTest3(){
        System.out.println("Cart Test - 3");
    }


    @Test(groups = {"Payment", "CheckIn"})
    public void paymentTest1(){
        System.out.println("Payment Test - 1");
    }

    @Test(groups = {"Payment"})
    public void paymentTest2(){
        System.out.println("Payment Test - 2");
    }

    @Test(groups = {"Payment"})
    public void paymentTest3(){
        System.out.println("Payment Test - 3");
    }

}
