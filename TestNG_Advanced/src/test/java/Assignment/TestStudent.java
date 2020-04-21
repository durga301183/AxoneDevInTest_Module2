package Assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestStudent {

    int [] marks;

    @Test(groups = { "Smoke", "Regression" })
    public void testFindGrade_absent() {
        Student s = new Student();
        String actual = s.findGrade();
        Assert.assertNotNull(actual);
        assertEquals("Absent", actual);
    }

    @Test(groups = { "Regression" })
    public void testFindGrade_AGrade() {
        Student s = new Student();
        marks = new int[] {90,85,80,80,80};
        s.setMarks(marks);
        String actual = s.findGrade();
        Assert.assertNotNull(actual);
        assertEquals("A", actual);
    }

    @Test(groups = { "Regression" })
    public void testFindGrade_BGrade() {
        Student s = new Student();
        marks = new int[] {60,85,90,90,65};
        s.setMarks(marks);
        String actual = s.findGrade();
        Assert.assertNotNull(actual);
        assertEquals("B", actual);
    }

    @Test(groups = { "Regression" }, dependsOnMethods = "testFindGrade_BGrade")
    public void testFindGrade_CGrade() {
        Student s = new Student();
        marks = new int[] {55,85,30,60,65};
        s.setMarks(marks);
        String actual = s.findGrade();
        Assert.assertNotNull(actual);
        assertEquals("C", actual);
    }

    @Test(groups = { "Smoke", "Regression" })
    public void testFindGrade_Fail() {
        Student s = new Student();
        marks = new int[] {50,40,30,25,50};
        s.setMarks(marks);
        String actual = s.findGrade();
        Assert.assertNotNull(actual);
        assertEquals("Fail", actual);
    }

}
