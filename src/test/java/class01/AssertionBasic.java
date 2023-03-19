package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {

    public static WebDriver driver;

    @BeforeMethod//this is an example of a pre-condition of opening the website, maximizing screen, and implicit wait
    public void SetUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod//this is an example of a post condition of closing the browser after a testor all tests
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void loginFunctionality() {
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("dummypass");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
String errorMsg=error.getText();
String expectedError="Invalid credential";
//assert the value
        Assert.assertEquals(expectedError,errorMsg);//expected error is our expected value which we wrote
        //errorMSG is the get text from the web element that we are comparing with the expected error
        System.out.println("I am here");//this line will not be printed because as soon as there is a failure in a test
        //the rest of the test code will not run. and will not test the other assertions

        //verify if password textbox is displayed
        //need to find the password element again as it is discarded when we clicked on login button because the dom refreshed
        password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
       boolean passwordDisplayed= password.isDisplayed();
        Assert.assertTrue(passwordDisplayed);
    }
}
