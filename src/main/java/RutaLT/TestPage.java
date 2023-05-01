package RutaLT;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestPage extends BasePage {

    private Registration registration;
    public TestPage() {
        super(driver);
    }
    @BeforeClass
    public static void setUp(){
    System.setProperty("webdriver.chrome.driver", "D:/Mano/Mokslai/IT mokymai/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        TestPage.driver = new ChromeDriver(options);
        TestPage.driver.manage().window().maximize();
    }

    @Test
    public void registration(){
        BasePage.goTo();
        Registration.acceptCookie();
//        Registration.registrations();
        Registration.logingIn();
        Registration.changePasword();

    }
    @AfterClass
    public static void teardown(){
//        driver.quit();
    }

}
