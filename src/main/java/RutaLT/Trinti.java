package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Trinti extends BasePage {


    private static final By eShopButton = By.cssSelector("?");


    public Trinti() {
        super(driver);
    }

    public static void trintiARRAYlist() {


//        System.setProperty("webdriver.gecko.driver", "D:/Mano/Mokslai/IT mokymai/Firefox/geckodriver.exe");
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
//        firefoxDriver = new FirefoxDriver(firefoxOptions);
//
//
//
//        System.setProperty("webdriver.chrome.driver", "D:/Mano/Mokslai/IT mokymai/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--disable-notifications");
//        chromeDriver = new ChromeDriver(chromeOptions);
//        chromeDriver.manage().window().maximize();
//        chromeDriver.get("https://www.ruta.lt");
//


    }
}