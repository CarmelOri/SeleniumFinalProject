import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {

    public static ChromeDriver setupDriver(){
        System.setProperty("webdriver.chrome.driver","res\\chromedriver.exe");
        return new ChromeDriver();
    }
}
