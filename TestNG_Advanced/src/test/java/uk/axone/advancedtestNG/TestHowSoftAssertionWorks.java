package uk.axone.advancedtestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestHowSoftAssertionWorks {

    SoftAssert soft;

    @Test
    public void testSoftAssertionSample(){
        int expVal = 123;
        int actVal = 456;

        System.out.println("My first line");

        soft = new SoftAssert();
        soft.assertEquals(actVal, expVal); // error
        soft.assertTrue(2>1, "Condition eval to false"); //no error
        soft.assertTrue(false, "Condition evaluated to false"); // error
        soft.assertFalse(true); //error

        System.out.println("My Last line");

    }
//when we write tests and if we know the severity of bug , if trivial then we can put it under the soft assertion
    @AfterTest
    public void tearDown(){
        soft.assertAll();
    }
}



