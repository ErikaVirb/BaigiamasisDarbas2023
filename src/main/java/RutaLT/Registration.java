package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Registration extends BasePage {

    // acceptCookie:
    private static final By cookieButton = By.cssSelector("div[class='cookies-holder'] button:nth-child(2)");
    // registrations:
    private static final By myAccountButton = By.xpath("/html/body/div[1]/header/div/div[3]/div/div[4]/ul/li[2]/a");
    private static final By regEmail = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[2]/div/form/p[1]/input");
    private static final By registrationButton = By.cssSelector("button[value='Registruotis']");
    private static final By disconnectButton = By.cssSelector("ul[class='account-nav nav nav-line nav-uppercase nav-vertical mt-half'] li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout'] a");



    public Registration() {
        super(driver);
    }

    public static void acceptCookie() throws IOException {

        try {
            WebElement cookieAccept = driver.findElement(cookieButton);
            cookieAccept.click();
        } catch (Exception e) {
            System.out.println("PopUp not displayd");
        }
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }

        public static void registrations() throws IOException {


            WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountButton));
                accountButton.click();

                WebElement emailField = driver.findElement(regEmail); //emailInput(){
//        String emailData = "skirmantas.skirmantas@yahoo.com";
                String emailData = "skirman.skirmat@yahoo.com";
                emailField.sendKeys(emailData);

                WebElement registrButton = driver.findElement(registrationButton);
                registrButton.click();

                WebElement discButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(disconnectButton));
                discButton.click();

            } catch (Exception e) {
                System.out.println("My account Button is not found. ");
            }
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Path destinationPath = Paths.get("sreenshot.png");
            Files.copy(screenshotFile.toPath(), destinationPath);
        }
    }
