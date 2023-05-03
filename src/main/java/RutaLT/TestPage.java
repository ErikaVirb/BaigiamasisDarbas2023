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
    private ShoppingBag shoppingBag;
    private ChooseCheapestProducts chooseCheapestProducts;
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
    public void registration() {
        BasePage.goTo();
        Registration.acceptCookie();
//        Registration.registrations();
//        Registration.logingIn(); // reikia dar su netikru prisijungimu
//        Registration.changePasword();
    }
    @Test
    public void shoppingBag(){
        BasePage.goTo();
        Registration.acceptCookie();
        Registration.logingIn();
        ShoppingBag.ePardChoseCategory();
        ShoppingBag.chooseFirstProduct();
//        shoppingBag.chooseSecondProduct();

        }
    @Test
    public void listOfProducts(){
        ChooseCheapestProducts.list();
    }


    @AfterClass
    public static void teardown(){
//        driver.quit();
    }

}
