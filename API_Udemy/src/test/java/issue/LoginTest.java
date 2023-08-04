package issue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    void loginTest(String userName, String passWord)
    {
        /** Path of chrome driver **/
        /** that will be local directory path passed **/
        /** For Window**/
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
        /** For Mac**/
        System.setProperty("webdriver.chrome.driver", "/Users/pankaj.gup/Downloads/software/chromedriver");
        driver = new ChromeDriver();
        /** URL of the login website that is tested **/
        driver.get("https://www.facebook.com/");
        /** Maximize window size of browser **/
        driver.manage().window().maximize();
        /** Enter your login email id **/
        driver.findElement(By.id("email")).sendKeys(userName);
        /** Enter your login password **/
        driver.findElement(By.id("pass")).sendKeys(passWord);
        /** Click on Login button **/
        driver.findElement(By.name("login")).click();
    }

    @Test
    void testIncorrectLogin()
    {
        loginTest("admin@gmail.com","pass12345");
        String actualResult =
                driver.findElement(By.xpath("//*[contains(text(),\"The password that you've entered is incorrect\")]")).getText();
        Assert.assertEquals(actualResult,"The password that you've entered is incorrect. Forgotten password?");
    }

    @Test
    void testBlankUserLogin()
    {
        loginTest("","pass12345");
        String actualResult =
                driver.findElement(By.xpath("//*[contains(text(),\"The email address or mobile number\")]")).getText();
        Assert.assertEquals(actualResult,"The email address or mobile number you entered isn't connected to an account. Find your account and log in.");
    }

    @Test
    void testBlankPassLogin()
    {
        loginTest("admin@gmail.com","");
        String actualResult =
                driver.findElement(By.xpath("//*[contains(text(),\"The password that you've entered is incorrect\")]")).getText();
        Assert.assertEquals(actualResult,"The password that you've entered is incorrect. Forgotten password?");
    }
}
