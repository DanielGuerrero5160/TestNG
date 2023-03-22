package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssert {
//go to syntax hrms
    //send no credentials and click on login button
    //verify the error message is username cannot be empty
    public static WebDriver driver;
    @BeforeMethod
 public void SetUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void testCase(){
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();
        WebElement errorMsg=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualError=errorMsg.getText();
        String expectedError="Username cannot be empty";

        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualError,expectedError);

        //login button is displayed or not
        boolean disp= loginButton.isDisplayed();
        System.out.println("The state of the display login is"+disp);//this proves that the code execution
        //does not stop after the soft assert fails
        soft.assertTrue(disp);

        //once you have made all assertions in the test case, we use soft.assertAll() at the end
       //in the compiler, it will tell is which assertions are failing
        //this is necessary for all soft assertions
        soft.assertAll();





    }
}
