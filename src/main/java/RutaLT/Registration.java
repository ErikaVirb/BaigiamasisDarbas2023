package RutaLT;

import org.apache.commons.io.FileUtils;
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
import java.util.Date;

public class Registration extends BasePage {

    // acceptCookie:
    private static final By cookieButton = By.cssSelector("div[class='cookies-holder'] button:nth-child(2)");
    // registrations:
    private static final By myAccountButton = By.xpath("/html/body/div[1]/header/div/div[3]/div/div[4]" +
            "/ul/li[2]/a");
    private static final By regEmail = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[2]" +
            "/div/form/p[1]/input");
    private static final By registrationButton = By.cssSelector("button[value='Registruotis']");
    private static final By disconnectButton = By.cssSelector("ul[class='account-nav nav nav-line nav-uppercase " +
            "nav-vertical mt-half'] li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation" +
            "-link--customer-logout'] a");
    private static final By greetingText = By.cssSelector("body div strong:nth-child(1)");//strong:nth-child(1)


    public Registration() {
        super(driver);
    }

    public static void acceptCookie() throws IOException {

        try {
            // Paspaudžiame slapukų iššokančioje lentelėje "Leisti viską"
            WebElement cookieAccept = driver.findElement(cookieButton);
            cookieAccept.click();
        } catch (Exception e) {
            System.out.println("PopUp not displayd");
        }

        try {
            // Darome sceenshot'us:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
        } catch (Exception e) {
            System.out.println("Screenshot disabled");
        }
    }
        public static void registrations() throws IOException {


            // Apsibrėžiam wait'a naudojimui visam metodui.
            WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(25));
            try {
                // Spaudžiame mygtuką "Mano paskyra".
                WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated
                        (myAccountButton));
                accountButton.click();
                // "REGISTRUOTIS" skiltis "MANO PASKYROJE". Bandome atlikti Registraciją su dar neregistruotu email:
                // Įvedam NEregistruotą email į laukelį "El.paštas*" :
                WebElement emailField = driver.findElement(regEmail);
//                String emailData = "registracija.registration@gmail.com";
//                String emailData = "registrac.registration@gmail.com";
                String emailData = "parduotuv.parduotuv@yahoo.com";
                emailField.sendKeys(emailData);
                //  Nusiskaitom tekstą iš įvesto laukelio tik iki @ simbolio:
                String emailFieldValue = emailField.getAttribute("value");
                // Nustatom ko mes tikimės iš tikrinamos nuskaitytos reikšmės
                String expectedPrefix = "parduotuve.parduotuve";
                //  Nusiskaitom tekstą iš įvesto laukelio tik iki @ simbolio jei toks bus:
                String actualPrefix = emailFieldValue.substring(0, emailFieldValue.indexOf("@"));
                // Spaudžiame "Registuotis" mygtuką
                WebElement registrButton = driver.findElement(registrationButton);
                registrButton.click();

                // Nustamom laukimo laiką - elementą tikrins 35 sekundes kas 2 sekundes.
                Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(35))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
                // Sulaukiame pasveikinimo texto ir jį nusiskaitome su 'getText'
                WebElement grText = wait.until(ExpectedConditions.visibilityOfElementLocated(greetingText));
                String textValue = grText.getText();
                Thread.sleep(2000);

                // Lyginame dvi reikšmes ar jos yra vienodos "iš abiejų pusių" - ar reikšmė kurios tikimąsi yra
                // lygi reikšmei kurios mes ieškom / kurią esam nusistatę IR atvirkščiai.
                if (expectedPrefix.equals(actualPrefix) && actualPrefix.equals(textValue)) {
                    System.out.println("The email field value and the text value are the same.");
                } else {
                    System.out.println("The email field value and the text value are different.");
                }

                // Spaudžiame mygtuką "Atsijungti"
                WebElement discButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated
                        (disconnectButton));
                discButton.click();

            } catch (Exception e) {
                System.out.println("Greeting text not found. ");
            }
            try {
                // Darome sceenshot'us:
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
                Date currentDate = new Date();
                String dateTime = dateFormat.format(currentDate);
                String fileName = "screenshot-" + dateTime + ".png";
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                        "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
            }catch (Exception e){
                System.out.println("Screenshot disabled");
            }
        }
        public static void alreadyExistingEmailRegistration() throws IOException{


            // Apsibrėžiam wait'a naudojimui visam metodui.
            WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            try {
                // Spaudžiame mygtuką "Mano paskyra".
                WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated
                        (myAccountButton));
                accountButton.click();
                // "REGISTRUOTIS" skiltis "MANO PASKYROJE". Bandome atlikti Registraciją su jau registruotu email:
                // Įvedam registruotą email į laukelį "El.paštas*" :
                WebElement emailField = driver.findElement(regEmail);
                String emailData = "skirmantas.skirmantas@yahoo.com";
                emailField.sendKeys(emailData);
                // Spaudžiame "Registuotis" mygtuką
                WebElement registrButton = driver.findElement(registrationButton);
                registrButton.click();
                Thread.sleep(3000);

            } catch (Exception e) {
                System.out.println("Email Field is not found. ");
            }
            try {
                // Darome sceenshot'us:
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
