//package RutaLT;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//
//import java.time.Duration;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public class FBasePage {
//    protected static WebDriver chromeDriver;
//    protected static WebDriver firefoxDriver;
//
//    public FBasePage(WebDriver driver){
//        BasePage.driver = driver;
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
//    public static void goTo(){
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--start-maximized");
//        firefoxDriver = new FirefoxDriver(options);
//        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        firefoxDriver.get("https://www.ruta.lt/");
//    }
//}
