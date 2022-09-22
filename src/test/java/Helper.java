import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {

    public static ChromeDriver setupDriver(){
        System.setProperty("webdriver.chrome.driver","res\\chromedriver.exe");
        return new ChromeDriver();
    }

    public static final String THREADLESS_URL = "https://www.threadless.com/";
    public static final String HERO_URL = "https://the-internet.herokuapp.com/";
    public static final String CHECKBOX_XPATH = "//*[@id=\"content\"]/ul/li[6]/a";
    public static final String CHECKBOX_URL = "https://the-internet.herokuapp.com/checkboxes";
    public static final String CHECKBOX_ONE = "//*[@id=\"checkboxes\"]/input[1]";
    public static final String CHECKBOX_TWO = "//*[@id=\"checkboxes\"]/input[2]";
    public static final String THREADLESS_MATT_URL = "https://www.threadless.com/shop/@papibulldozer/design/matt-bellamy-portrait/mens/t-shirt/regular?color=white#m";
    public static final String THREADLESS_LOGINXPATH = "/html/body/nav/header/ul/li[2]/a";
    public static final String THREADLESS_LOGINFIELDUSER_ID = "id_username";
    public static final String THREADLESS_LOGINFIELDPASS_ID = "id_password";
    public static final String THREADLESS_USERNAME = "TargilSiyum";
    public static final String THREADLESS_PASSWORD = "TargilSiyum1!";
    public static final String THREADLESS_LOGMEINBTN_XPATH = "//*[@id=\"login_form\"]/fieldset/input[2]";
    public static final String MUSEWIKIURL = "https://en.wikipedia.org/wiki/Muse_(band)";
    public static final String MUSETEXTPARAGRAPHxPATH = "//*[@id=\"mw-content-text\"]/div[1]/p[9]";
    public static final String FOLDERPATH = "C:\\Users\\nitzc\\Screenshots\\";
    public static final String TXT = ".txt";
    public static final String JPG = ".jpg";
}
