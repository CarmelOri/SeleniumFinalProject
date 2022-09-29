import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        Thread.sleep(1000);
        driver.manage().window().minimize();
        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
        driver.manage().window().maximize(); //resize
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
    public void heroTesting() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.HERO_URL); //entering the site
        driver.manage().window().maximize();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("alert('Hello i am an alert, please dismiss me')");
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement checkboxXpath = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.CHECKBOX_XPATH))); //checkboxes
        checkboxXpath.click();
        if (driver.getCurrentUrl().equals(Helper.CHECKBOX_URL)) {
            WebElement checkOne = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.CHECKBOX_ONE)));
            WebElement checkTwo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.CHECKBOX_TWO)));
            checkOne.click();
            Thread.sleep(1000);
            checkTwo.click();
            Thread.sleep(1000);
            checkTwo.click();
            Thread.sleep(3000);
            System.out.println("both checkboxes are selected = " + "checkbox one: " + checkOne.isSelected() + ", checkbox two: " + checkTwo.isSelected());
        } else {
            System.out.println("wrong URL :'((");
        }
        driver.navigate().to(Helper.HEROMENU_URL);
        Thread.sleep(2000);
        WebElement dropdownXpath = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.HERODROPDOWN_XPATH)));
        dropdownXpath.click();
        Select dropdown = new Select(driver.findElement(By.id(Helper.DROPDOWN_ID)));
        dropdown.selectByIndex(2);
    }
    @Test
    public void actionsNassert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.DEMO_URL);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        actions.doubleClick(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.DOUBLECLICK_ID)))).perform();
        Thread.sleep(2000);
        driver.navigate().to(Helper.DOUBLECLICKGIF_URL);
        Thread.sleep(2000);
        driver.navigate().back();
        actions.contextClick(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.CONTEXTCLICK_ID)))).perform();
        Thread.sleep(2000);
        driver.navigate().to(Helper.CONTEXTCLICKGIF_URL);
        Thread.sleep(3000);
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), Helper.DEMO_URL);
    }

    @Test
    public void wikipedia() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.MUSEWIKIURL);
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1700)");
        File newFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //taking the screenshot
        File filePath = new File(Helper.FOLDERPATH + "wikiPhoto" + Helper.JPG);
        FileUtils.copyFile(newFile, filePath);
        WebElement wikiText = driver.findElement(By.xpath(Helper.MUSETEXTPARAGRAPHxPATH));
        File textFile = new File(Helper.FOLDERPATH + "WikiParagraphText" + Helper.TXT); //copy the text into a txt folder
        FileWriter writer = new FileWriter(textFile);
        writer.write(wikiText.getText());
        writer.close();
    }
}


