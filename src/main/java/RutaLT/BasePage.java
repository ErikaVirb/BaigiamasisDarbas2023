package RutaLT;

//BasePage.java
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;

//        BasePage.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void goTo(){
        driver.get("https://www.ruta.lt/");
    }

}


