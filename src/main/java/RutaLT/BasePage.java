package RutaLT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasePage {


//    protected static WebDriver driver;

    protected static FirefoxDriver driver;

    public BasePage(FirefoxDriver driver){
        BasePage.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    public BasePage(WebDriver driver){
//        BasePage.driver = driver;
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
    public static void goTo(){
        driver.get("https://www.ruta.lt/");
    }
}
