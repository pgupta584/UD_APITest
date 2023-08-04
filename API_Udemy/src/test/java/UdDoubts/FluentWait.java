package UdDoubts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FluentWait<W extends SearchContext> {

    public static WebDriver driver;

    public static void main(String[] args) {
// TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                "F:\\Automation\\Practices\\SeleniumBasics\\ThirdParty_Resource_Files\\ChromeDriver\\V108.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//driver.navigate().to("https://spur-sprint.uat-gears-int.com/");
        driver.navigate().to("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("selenium");
        search.sendKeys(Keys.ENTER);

//        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
//                .withTimeout(30, TimeUnit.SECONDS)
//                .pollingEvery(5, TimeUnit.SECONDS)
//                .ignoring(NoSuchElementException.class);

        //Wait wait = new FluentWait(WebDriver driver)
//        Wait<WebDriver> wait=new FluentWait<WebDriver>(WebDriver driver)
//                .withTimeout(Duration.ofSeconds(TimeUnit.SECONDS.toSeconds(10)))
//                .pollingEvery(Duration.ofSeconds(TimeUnit.SECONDS.toSeconds(10)))
//                .ignoring(Exception.class);

        //

        /*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement search2 = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver ) {
                return driver.findElement(By.xpath("//*[text()='Selenium - A browser automation framework and ecosystem.']"));
            }
        });
        search2.click();*/
        }
    }