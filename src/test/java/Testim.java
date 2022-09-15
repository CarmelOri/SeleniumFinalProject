import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testim {

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void testOne(){
        WebDriver driver = new ChromeDriver();
    }

}


