package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGExample {
    //test 1
    //go to syntax hrms
    //enter username and password, verify we are logged in, and close the browser

    public static WebDriver driver;
    @BeforeMethod//this is an example of a pre-condition of opening the website, maximizing screen, and implicit wait
    public void SetUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
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
    public void loginFunctionality(){
        WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("Admin");

        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

    }
    @Test
    public void passwordTextBoxVerification(){

        //find web element password text box
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        System.out.println( password.isDisplayed());
    }


}
