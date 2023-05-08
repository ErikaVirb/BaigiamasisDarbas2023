package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class LogingIn extends BasePage{


    private static final By myAccountButton = By.xpath("/html/body/div[1]/header/div/div[3]/div/div[4]/ul/li[2]/a");
    private static final By connectEmailInput = By.cssSelector("input[name='username']");
    private static final By connectPasswordInput = By.cssSelector("input[name='password']");
    private static final By connectButton = By.cssSelector("button[value='Prisijungti']");

    public LogingIn() {
        super(driver);
    }

    public static void logingIn() throws IOException {


        WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountButton));
            accountButton.click();
        } catch (Exception e) {
            System.out.println("My account Button is not found. ");
        }
        try {
            WebElement emailField = driver.findElement(connectEmailInput);
            String emailData = "skirmantas.skirmantas@yahoo.com";
            emailField.sendKeys(emailData);

            WebElement passwordIn = driver.findElement(connectPasswordInput);
            String passwordInp = "palubinskasIrCo123";
            passwordIn.sendKeys(passwordInp);
            Thread.sleep(1000);

            WebElement connButton = driver.findElement(connectButton);
            connButton.click();

        } catch (Exception e) {
            System.out.println("Connect button not found.");
        }
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }
}
