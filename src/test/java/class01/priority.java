package class01;

import org.testng.annotations.Test;

public class priority {

    @Test(priority = 3)
    public void Atest(){
        System.out.println("I am test a");
    }
    @Test(priority = 1)//if we had a priority 0, it would be the highest priority
    public void Btest(){
        System.out.println("I am test B");
    }
    @Test(priority = 2)
    public void Ctest(){
        System.out.println("I am test C");
    }
}
