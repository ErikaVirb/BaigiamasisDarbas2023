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
    private LoggingIn loggingIn;
    private ChangePassword changePassword;
    private ShoppingBag shoppingBag;
    private ChooseCheapestProducts chooseCheapestProducts;
    private ArraySearchProduct arraySearchProduct;
    private BandymaiIstrinti bandymaiIstrinti;


    public TestPage() {
        super(driver);
    }


    @BeforeClass
    public static void setUp(){

        // CHROME:
    System.setProperty("webdriver.chrome.driver", "D:/Mano/Mokslai/IT mokymai/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        TestPage.driver = new ChromeDriver(options);
        TestPage.driver.manage().window().maximize();

        // FIREFOX:

//    System.setProperty("webdriver.gecko.driver", "D:/Mano/Mokslai/IT mokymai/Firefox/geckodriver.exe");
//        FirefoxOptions options1 = new FirefoxOptions();
//        options1.addArguments("--disable-notifications");
//
//        TestPage.driver = new FirefoxDriver(options1);
//        TestPage.driver.manage().window().maximize();

    }

    @Test
    public void registration() throws IOException {  // VEIKIA. DAR REIKIA: screenshots;
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
//        Registration.registrations();
//        Registration.alreadyExistingEmailRegistration();
    }
    @Test
    public void logingIn() throws IOException { // VEIKIA. DAR REIKIA: screenshots;
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
//        LoggingIn.loggingIn();
//        ChangePassword.changePassword();
//        LoggingIn.incorrectDatalogingIn();
    }

    @Test
    public void shoppingBag() throws IOException {
        BasePage.goTo();
        Registration.acceptCookie();
        PopUpSubscription.subscription();
        ShoppingBag.eShopChoseCategory();
        ShoppingBag.chooseFirstProduct();
        ShoppingBag.chooseSecondProduct();
        ShoppingBag.chooseThirdProduct();
        ShoppingBag.manageShopBag();

        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @Test
//    public void ArraySearchProduct()throws IOException {
//
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
//        ArraySearchProduct.searchByTitle();
//    }
//    @Test
//    public void BandymaiArraySearchProduct()throws IOException {
//
//        BasePage.goTo();
//        Registration.acceptCookie();
//        PopUpSubscription.subscription();
//        BandymaiIstrinti.ArraySearchProductBandymai();
//    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
