package uk.axone.screenshots;

import org.testng.annotations.Test;

public class SampleJavaTypecasting {
    @Test

    public void testSampleTypeCast(){

        double salary= 999.99;
        int mysalary;
        System.out.println("Double Sal:" + salary);
// typecasting. treat it as integer
        //superclass to sub class is called down casting, viceversa is upcasting
        mysalary = (int) salary;
       System.out.println("After casting:"+ mysalary);
    }


}
