package uk.axone.advancedtestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestHowAssertionWorks {

    SoftAssert soft;

//1. assertEquals
    //2. assertTrue
    //3. assertFalse

    @Test
    public void testAssertEquals(){
        String expectedVal = "Axone";
        String actualVal = "Axone.uk";

        System.out.println("First line of code");
        Assert.assertEquals(actualVal, expectedVal,"Strings are unequal..");
        System.out.println("Last line of code");

    }

    @Test
    public void testAssertionTrue(){


        System.out.println("First line of code");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(2 > 11,"Condition evaluated to false");
        System.out.println("Last line of code");

    }

    @Test
    public void testAssertionFalse(){
        System.out.println("First line of code");
        Assert.assertFalse(2 < 11, "Condition evaluated to True");
        System.out.println("Last line of code");
    }
}




