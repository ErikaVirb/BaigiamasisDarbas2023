package RutaLT;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class PopUpSubscription extends BasePage {

    private static final By iframe = By.cssSelector("#ml-webforms-popup-5855857");
    private static final By popUpEmailInput = By.cssSelector(".form-control");
    private static final By popUpsCloseAfterSubscription = By.cssSelector("div.ml-popup:nth-child(2)" +
            " > button:nth-child(1)");
    private static final By subscribeButton1 = By.cssSelector("button.btn:nth-child(1)");

    public PopUpSubscription() {
        super(driver);
    }


    public static void subscription() throws IOException {

        // Apsibrėžiam wait'a naudojimui visam metodui.
        WebDriverWait milerWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Sufokusuojam driver'io "dėmesį" į Iframe - tai yra HTML elementas, jis įkeltas iš kito HTML dokumento
            // kuris elgiasi kaip atskiras webpage su savo HTML ir CSS ir JavaScriptu.
            WebElement mailerIframe = milerWait.until(ExpectedConditions.visibilityOfElementLocated(iframe));
            driver.switchTo().frame(mailerIframe);
            // Įvedame į laukelį "Email" elektroninio pašto adresą
            WebElement subscribeButton = driver.findElement(popUpEmailInput);
            subscribeButton.sendKeys("virginija.petruliene@yahoo.com");
            Thread.sleep(5000);
            // Spaudžiame mygtuką "Prenumeruoti"
            WebElement closeIframe = driver.findElement(subscribeButton1);
            closeIframe.click();
            // Uždarome lentelę su padėkos tekstu, kad užsisakėm prenumeratą
            WebElement popUpClose = milerWait.until(ExpectedConditions.visibilityOfElementLocated
                    (popUpsCloseAfterSubscription));
            popUpClose.click();
            // Gražiname driver'io fokusą į mūsų testuojamą web page HTML
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            System.out.println("Miler Lite Frame not in display");
        }
    }
}

