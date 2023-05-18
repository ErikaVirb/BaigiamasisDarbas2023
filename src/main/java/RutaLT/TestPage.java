package RutaLT;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Kad testai eitų paeiliui pradedant nuo viršutinio pirmojo kodo.
// Keičiant "NAME_ASCENDING" galima keisti testų paleidimo eiliškumą.


public class TestPage extends BasePage {

    private static WebDriver driver;


    private PopUpSubscription popUpSubscription;
    private Registration registration;
    private LoggingIn loggingIn;
    private ChangePassword changePassword;
    private ShoppingBag shoppingBag;
    private ProductsFilter productsFilter;
    private ManageShopBag manageShopBag;
    private ArraySearchProduct arraySearchProduct;

    public TestPage() {
        super(driver);
    }

    @BeforeClass
    public static void setUp() {
        // ChromeDriver:
        System.setProperty("webdriver.chrome.driver", "D:/Mano/Mokslai/IT mokymai/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        TestPage.driver = new ChromeDriver(options);
        TestPage.driver.manage().window().maximize();

        // FirefoxDriver:
//        System.setProperty("webdriver.chrome.driver", "D:/Mano/Mokslai/IT mokymai/Firefox/geckodriver.exe");
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
//        driver = new FirefoxDriver(firefoxOptions);
//        driver.manage().window().maximize();
    }
    @Test
    public void arraySearchProduct() throws IOException {
        BasePage.goTo();
        Registration.acceptCookie();
        PopUpSubscription.subscription();
        ArraySearchProduct.searchByTitle();
    }
    @Test
    public void loggingIn() throws IOException {
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
        LoggingIn.loggingIn();
        ChangePassword.changePassword();
        LoggingIn.incorrectDatalogingIn();
    }
    @Test
    public void productsFilter() throws IOException {
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
        ProductsFilter.biggestPriceDescending();
        ProductsFilter.smollestPriceAscending();
    }
    @Test
    public void registration() throws IOException {
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
        Registration.registrations();
        Registration.alreadyExistingEmailRegistration();
    }
    @Test
    public void shoppingBag() throws IOException {
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
        ShoppingBag.eShopChoseCategory();
        ShoppingBag.chooseFirstProduct();
        ShoppingBag.chooseSecondProduct();
        ShoppingBag.chooseThirdProduct();
        ManageShopBag.manageShopBag();
    }
    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
