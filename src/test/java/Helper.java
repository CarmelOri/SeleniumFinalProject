import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {

    public static ChromeDriver setupDriver(){
        System.setProperty("webdriver.chrome.driver","res\\chromedriver.exe");
        return new ChromeDriver();
    }

    public static final String THREADLESS_URL = "https://www.threadless.com/";
    public static final String THREADLESS_MATT_URL = "https://www.threadless.com/shop/@papibulldozer/design/matt-bellamy-portrait/mens/t-shirt/regular?color=white#m";
    public static final String THREADLESS_LOGINXPATH = "/html/body/nav/header/ul/li[2]/a";
    public static final String THREADLESS_LOGINFIELDUSER_ID = "id_username";
    public static final String THREADLESS_LOGINFIELDPASS_ID = "id_password";
    public static final String THREADLESS_USERNAME = "TargilSiyum";
    public static final String THREADLESS_PASSWORD = "TargilSiyum1!";
    public static final String THREADLESS_LOGMEINBTN_XPATH = "//*[@id=\"login_form\"]/fieldset/input[2]";
    public static final String MUSEWIKIURL = "https://eincyclopedia.org/wiki/%D7%9E%D7%99%D7%95%D7%96";
}
