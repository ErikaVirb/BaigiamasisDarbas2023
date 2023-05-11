package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

public class Registration extends BasePage {

    // acceptCookie:
    private static final By cookieButton = By.cssSelector("div[class='cookies-holder'] button:nth-child(2)");
    // registrations:
    private static final By myAccountButton = By.xpath("/html/body/div[1]/header/div/div[3]/div/div[4]/ul/li[2]/a");
    private static final By regEmail = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[2]/div/form/p[1]/input");
    private static final By registrationButton = By.cssSelector("button[value='Registruotis']");
    private static final By disconnectButton = By.cssSelector("ul[class='account-nav nav nav-line nav-uppercase nav-vertical mt-half'] li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout'] a");
    private static final By greetingText = By.cssSelector("strong:nth-child(1)");


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

//        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        SimpleDataFormat timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//        )
//        try{
//            String screenshotPath = "D:\\Mano\\Mokslai\\IT mokymai\\Baigiamasis2023\\ScreenshotFilesreenshot.png" + timestamp + "_screenshot";
//            Path destinationPath = Path.of(screenshotPath);
//            Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (Exception e){
//            System.out.println("Screenshot already exists");
//        }
//
//        Path destinationPath = Paths.get("D:\\Mano\\Mokslai\\IT mokymai\\Baigiamasis2023\\ScreenshotFilesreenshot.png");

//        driver.quit();
    }

        public static void registrations() throws IOException {


            WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            try {
                WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountButton));
                accountButton.click();
                WebElement emailField = driver.findElement(regEmail);
//                String emailData = "registracija.registration@gmail.com";
//                String emailData = "registrac.registration@gmail.com";
//                String emailData = "registrac.registration@yahoo.com";
                String emailData = "registr.registr@gmail.com";
                emailField.sendKeys(emailData);
                //  Pasiemam teksta tik iki @ simbolio
                String emailFieldValue = emailField.getAttribute("value");
                String expectedPrefix = "registr.registr";
                String actualPrefix = emailFieldValue.substring(0, emailFieldValue.indexOf("@"));
                WebElement registrButton = driver.findElement(registrationButton);
                registrButton.click();

                Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

                WebElement grText = wait.until(ExpectedConditions.visibilityOfElementLocated(greetingText));
                String textValue = grText.getText();

                if (expectedPrefix.equals(actualPrefix) && actualPrefix.equals(textValue)) {
                    System.out.println("The email field value and the text value are the same.");
                } else {
                    System.out.println("The email field value and the text value are different.");
                }

                WebElement discButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(disconnectButton));
                discButton.click();

            } catch (Exception e) {
                System.out.println("Greeting text not found. ");
            }

//            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            Path destinationPath = Paths.get("sreenshot.png");
//            Files.copy(screenshotFile.toPath(), destinationPath);
        }
        public static void alreadyExistingEmailRegistration() throws IOException{


            WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountButton));
                accountButton.click();
                WebElement emailField = driver.findElement(regEmail);
                String emailData = "skirmantas.skirmantas@yahoo.com";
                emailField.sendKeys(emailData);
                WebElement registrButton = driver.findElement(registrationButton);
                registrButton.click();
                Thread.sleep(3000);

            } catch (Exception e) {
                System.out.println("Email Field is not found. ");
            }

//            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            Path destinationPath = Paths.get("sreenshot.png");
//            Files.copy(screenshotFile.toPath(), destinationPath);

//            driver.quit();
        }
//
    }
