package RutaLT;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class TestPage extends BasePage {


    private PopUpSubscription popUpSubscription;
    private Registration registration;
    private LogingIn logingIn;
    private ShoppingBag shoppingBag;
    private ChooseCheapestProducts chooseCheapestProducts;


    public TestPage() {
        super(driver);
    }


    @BeforeClass
    public static void setUp(){

        // CHROME:
//    System.setProperty("webdriver.chrome.driver", "D:/Mano/Mokslai/IT mokymai/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//
//        TestPage.driver = new ChromeDriver(options);
//        TestPage.driver.manage().window().maximize();

        // FIREFOX:

    System.setProperty("webdriver.gecko.driver", "D:/Mano/Mokslai/IT mokymai/Firefox/geckodriver.exe");
        FirefoxOptions options1 = new FirefoxOptions();
        options1.addArguments("--disable-notifications");

        TestPage.driver = new FirefoxDriver(options1);
        TestPage.driver.manage().window().maximize();

    }

    @Test
    public void registration() throws IOException {  // veikia
        BasePage.goTo();
        Registration.acceptCookie();
//        PopUpSubscription.subscription();
//        Registration.registrations();
    }
    @Test
    public void logingIn() throws IOException { // veikia
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
//        LogingIn.logingIn(); // reikia dar su netikru prisijungimu
//        ChangePasword.changePasword();
    }
    @Test
    public void changePasword() throws IOException { // veikia
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
//        ChangePasword.changePasword();
    }
    @Test
    public void shoppingBag() throws IOException {
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
//        LogingIn.logingIn();
//        ShoppingBag.eShopChoseCategory();
//        ShoppingBag.chooseFirstProduct();
//        ShoppingBag.chooseSecondProduct();

        }
    @Test
    public void listOfProducts() throws IOException {
//        BasePage.goTo();
//        Registration.acceptCookie();
//        ChooseCheapestProducts.list();
    }
    @Test
    public void listComparison() throws IOException {
//        List<String> list1 = new ArrayList<>();
//        list1.add("Dog");
//        list1.add("Cat");
//        list1.add("Monkey");
//        list1.add("Horse");
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("Cat");
//        list2.add("Dog");
//        list2.add("Monkey");
//        list2.add("Horse");
//
//        assertArrayEquals(list1.toArray(), list2.toArray());
    }


    @AfterClass
    public static void teardown(){
//        driver.quit();
    }

}
