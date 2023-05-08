package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class PopUpSubscription extends BasePage {

    private static final By iframe = By.cssSelector("#ml-webforms-popup-5855857");
    private static final By popUpEmailInput = By.cssSelector(".form-control");
    private static final By popUpsCloseAfterSubscription = By.cssSelector("div.ml-popup:nth-child(2) > button:nth-child(1)");
    private static final By subscribeButton1 = By.cssSelector("button.btn:nth-child(1)");

    public PopUpSubscription() {
        super(driver);
    }

    public static void subscriptClick() throws IOException {

        // VEIKIA KAIP PASPAUDIMAS KAMPUTYJE (palikti):
        try {
            Thread.sleep(5000);
            Actions actions = new Actions(driver);
            actions.moveByOffset(0, 0).click().build().perform();
        } catch (Exception e) {
            System.out.println("Nerastas popupas");
        }
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }

    public static void subscription() throws IOException {


        WebDriverWait milerWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement mailerIframe = milerWait.until(ExpectedConditions.visibilityOfElementLocated(iframe));
            driver.switchTo().frame(mailerIframe);

            WebElement subscribeButton = driver.findElement(popUpEmailInput);
            subscribeButton.sendKeys("virginija.petruliene@yahoo.com");
            Thread.sleep(5000);

            WebElement closeIframe = driver.findElement(subscribeButton1);
            closeIframe.click();

            WebElement popUpClose = milerWait.until(ExpectedConditions.visibilityOfElementLocated(popUpsCloseAfterSubscription));
            popUpClose.click();

            driver.switchTo().defaultContent();

        } catch (Exception e) {
            System.out.println("Miler Lite Frame not in display");
        }
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);


    }
    // FluentWait
//    Wait<WebDriver> wait = new FluentWait<>(driver) // kai nebei6eina nieko padaryti reikia bandyti naudoti FluentWait.
//            .withTimeout(Duration.ofSeconds(10))
//            .pollingEvery(Duration.ofSeconds(1))
//            .ignoring(NoSuchElementException.class);

}


