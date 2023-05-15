package RutaLT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasePage {


    protected static WebDriver driver;
    protected static WebDriver firefoxDriver;
    public BasePage(WebDriver driver, WebDriver firefoxDriver){
        BasePage.driver = driver;
        BasePage.firefoxDriver = firefoxDriver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        firefoxDriver.manage().window().maximize();
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void goTo(){
        driver.get("https://www.ruta.lt/");
    }
}
