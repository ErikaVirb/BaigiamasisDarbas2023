package RutaLT;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class LoggingIn extends BasePage{


    private static final By myAccountButton = By.xpath("/html/body/div[1]/header/div/div[3]/div/div" +
            "[4]/ul/li[2]/a");
    private static final By connectEmailInput = By.cssSelector("input[name='username']");
    private static final By connectPasswordInput = By.cssSelector("input[name='password']");
    private static final By connectButton = By.cssSelector("button[value='Prisijungti']");
    private static final By errorText = By.cssSelector(".input-error");

    public LoggingIn() {
        super(driver);
    }
    public static void loggingIn() throws IOException {


        WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated
                    (myAccountButton));
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
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception o){
            System.out.println("Screenshot disabled");
        }
    }
    public static void incorrectDatalogingIn() throws IOException {


        WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated
                    (myAccountButton));
            accountButton.click();
        } catch (Exception e) {
            System.out.println("My account Button is not found. ");
        }
        try {
            WebElement emailField = driver.findElement(connectEmailInput);
            String emailData = "wokr.hard@gmail.com";
            emailField.sendKeys(emailData);
            WebElement passwordIn = driver.findElement(connectPasswordInput);
            String passwordInp = "EyesOnKybord";
            passwordIn.sendKeys(passwordInp);
            Thread.sleep(1000);
            WebElement connButton = driver.findElement(connectButton);
            connButton.click();

            String expectedErrorText = "neteisingas";
            String actualErrorText = driver.findElement(errorText).getText();

            if (actualErrorText.contains(expectedErrorText)) {
                System.out.println("The error message is correct!");
            } else {
                System.out.println("The error message is INCORECT!");
            }

        } catch (Exception e) {
            System.out.println("Connect button not found.");
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception o){
            System.out.println("Screenshot disabled");
        }

    }
}