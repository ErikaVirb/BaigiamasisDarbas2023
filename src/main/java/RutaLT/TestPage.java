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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class TestPage extends BasePage {


    private static ChromeDriver chromedriver;
    private static FirefoxDriver firefoxdriver;
    // Firefox:
    private FPopUpSubscription fPopUpSubscription;
    private FArraySearchProduct fArraySearchProduct;
    private FRegistration fRegistration;
    // Chrome:
    private PopUpSubscription popUpSubscription;
    private Registration registration;
    private LoggingIn loggingIn;
    private ChangePassword changePassword;
    private ShoppingBag shoppingBag;
    private ProductsFilter productsFilter;
    private ManageShopBag manageShopBag;
    private ArraySearchProduct arraySearchProduct;

    ///////////////////////////////////////////////////////////////////////////////
    private Trinti trinti;
    private BandymaiIstrinti bandymaiIstrinti;
    /////////////////////////////////////////////////////////////////////////////////

    public TestPage() {
        super(driver, firefoxDriver);
    }

    @BeforeClass
    public static void setUpChrome() {


        // CHROME:
    System.setProperty("webdriver.chrome.driver", "D:/Mano/Mokslai/IT mokymai/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        TestPage.driver = new ChromeDriver(options);
        TestPage.driver.manage().window().maximize();
//    }
//    @BeforeClass
//    public static void setUpFirefox(){

         //FIREFOX:
    System.setProperty("webdriver.gecko.driver", "D:/Mano/Mokslai/IT mokymai/Firefox/geckodriver.exe");
        FirefoxOptions options1 = new FirefoxOptions();
        options1.addArguments("--disable-notifications");

        TestPage.firefoxDriver = new FirefoxDriver(options1);
        TestPage.firefoxDriver.manage().window().maximize();
    }

    // Chrome:
    @Test
    public void registration() throws IOException {  // VEIKIA. DAR REIKIA: screenshots;
        BasePage.goTo();
        Registration.acceptCookie();
        PopUpSubscription.subscription();
        Registration.registrations();
        Registration.alreadyExistingEmailRegistration();
    }
    @Test
    public void loggingIn() throws IOException { // VEIKIA. DAR REIKIA: screenshots;
        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
        LoggingIn.loggingIn();
        ChangePassword.changePassword();
        LoggingIn.incorrectDatalogingIn();
    }
    @Test
    public void shoppingBag() throws IOException { // NEVEIKIA. Pastringa testas. Atskiros funkcijos veikia.
        BasePage.goTo();
        Registration.acceptCookie();
        PopUpSubscription.subscription();
        ShoppingBag.eShopChoseCategory();
        ShoppingBag.chooseFirstProduct();
        ShoppingBag.chooseSecondProduct();
        ShoppingBag.chooseThirdProduct();
        ManageShopBag.manageShopBag();

        }
    @Test
    public void productsFilter() throws IOException { // VEIKIA. DAR REIKIA: screenshots;
        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
        ProductsFilter.biggestPriceDescending();
        ProductsFilter.smollestPriceAscending();
    }
    @Test
    public void ArraySearchProduct() throws IOException { //ĄĄĄĄĄĄĄĄĄĄĄĄĄĄ VEIKIA. DAR REIKIA: screenshots;
        BasePage.goTo();
        FRegistration.acceptCookie();
        PopUpSubscription.subscription();
        ArraySearchProduct.searchByTitle();
    }

    // Firefox:
    @Test
    public void FArraySearchProduct() throws IOException { //ĄĄĄĄĄĄĄĄĄĄĄĄĄĄ VEIKIA. DAR REIKIA: screenshots;
        BasePage.goTo();
        FRegistration.acceptCookie();
        FPopUpSubscription.subscription();
        FArraySearchProduct.searchByTitle();
    }
//    @Test
//    public void listComparison() throws IOException {
////        List<String> list1 = new ArrayList<>();
////        list1.add("Dog");
////        list1.add("Cat");
////        list1.add("Monkey");
////        list1.add("Horse");
////
////        List<String> list2 = new ArrayList<>();
////        list2.add("Cat");
////        list2.add("Dog");
////        list2.add("Monkey");
////        list2.add("Horse");
////
////        assertArrayEquals(list1.toArray(), list2.toArray());
//    }


    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
