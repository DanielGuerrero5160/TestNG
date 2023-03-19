package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGannotations {
    @BeforeMethod//we cannot run the before method by itself
    public void beforeMethods(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethods(){
        System.out.println("I am an after method");
    }

    @Test
    public void AfirstTestCase(){
        System.out.println("I am the first test case");
    }
    @Test
    public void bSecondTestCase(){

        System.out.println("I am the second test case");
    }
    @Test
    public void cThirdTestCase(){
        System.out.println("I am the third test case");
    }
}
