package uk.axone.coreframework.oopsrefresher;

import org.openqa.selenium.WebDriver;

public class POJOClass {
//ALWAYS IMPLEMENT INSTAMNCE VARIABLES AS POJO. READ ONLY CLASS
    //DATA HIDING-ER ARE HIDING BOTH DATA AND METHODS TO ACCESS THE DATA CLASS IN A SINGLE CLASS
    //POJO- PLAIN OLD JAVA OBJECT
    //instance variables must be private

    /*
    POJO:- POJO is a Java object not bound by any restriction other than those forced by the Java Language Specification.

Properties of POJO

All properties must public setter and getter methods
All instance variables should be private
Should not Extend prespecified classes.
Should not Implement prespecified interfaces.
Should not contain prespecified annotations.
It may not have no argument constructor
     */

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
