package class01;

import org.testng.annotations.Test;

public class dependsOn {
    @Test
    public void Login(){
       //this will cause the first test to fail, and the second will not run because the first was not successful
        // System.out.println(6/0);
    }

    @Test(dependsOnMethods = {"Login"})
    public void DashboardVerification(){
        System.out.println("After login, I am verifying dashboard");
    }


}
