import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Testim {

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void threadlessLoginNscroll() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.THREADLESS_URL); //entering the site
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginbtn = //log in with pre-made user
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.THREADLESS_LOGINXPATH)));
        loginbtn.click();
        WebElement loginField =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.THREADLESS_LOGINFIELDUSER_ID)));
        loginField.click();
        loginField.sendKeys(Helper.THREADLESS_USERNAME);
        Thread.sleep(2000);
        WebElement passField =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.THREADLESS_LOGINFIELDPASS_ID)));
        passField.click();
        passField.sendKeys(Helper.THREADLESS_PASSWORD);
        Thread.sleep(2000);
        WebElement logMeInbtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.THREADLESS_LOGMEINBTN_XPATH)));
        logMeInbtn.click();
        String firstWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(Helper.THREADLESS_MATT_URL); //new link in new tab
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver; //scrolling
        jse.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,-(document.body.scrollHeight))");
    }
    @Test
    public void testTwo() {

    }
}


