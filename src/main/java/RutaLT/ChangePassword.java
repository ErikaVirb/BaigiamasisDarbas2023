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

public class ChangePassword extends BasePage{

    // RASTI BUG'ai: - Nėra informacinių pranešimų ar pavyko atnaujinti profilio duomenis.

    //  changePasword / atstatyri Pasword:
    private static final By myAccountEdit = By.cssSelector(".account-link.account-login");
    private static final By email = By.xpath("(//input[@name='account_email'])[1]");
    private static final By nameInput = By.cssSelector("input[name='account_first_name']");
    private static final By surNameInput = By.cssSelector("input[name='account_last_name']");
    private static final By existingPasswordInput = By.cssSelector("input[name='password_current']");
    private static final By newPasswordInput = By.cssSelector("input[name='password_1']");
    private static final By repeatedPasswordInput = By.cssSelector("input[name='password_2']");
    private static final By saveChangesButton = By.cssSelector("button[value='Išsaugoti pakeitimus']");
    private static final By disconnect = By.cssSelector("#my-account-nav > li:nth-child(5) > a:nth-child(1)");
    public ChangePassword() {
        super(driver);
    }


    // Pakeisti slaptažodį ir jį atstatyti:
    public static void changePassword() throws IOException {


        // Metodas naudojamas TIK PO PRISIJUNGIMO!!!!!
        // Apsibrėžiam wait'a naudojimui visam metodui.
        WebDriverWait myAccountEditWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Spaudžiame pasirinkimą "Vartotojo informacija"
            WebElement myAccount = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated
                    (myAccountEdit));
            myAccount.click();
            // Įvedame asmeninius duomenis "Vardas *":
            WebElement nameIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
            String nameIn1 = "Skirmantas";
            nameIn.sendKeys(nameIn1);
            // Įvedame asmeninius duomenis "Pavardė *":
            WebElement surnameIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(surNameInput));
            String surIn1 = "Skirmantas";
            surnameIn.sendKeys(surIn1);
            // Scroll'inam 400 pikselių žemyn, kad pasimatytų laukeliai "KEISTI SLAPTAŽODĮ"
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(800);
            // Įvedame asmeninius duomenis "Esamas slaptažodis":
            WebElement passwordIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated
                    (existingPasswordInput));
            // Įvedame asmeninius duomenis "Naujas slaptažodis":
            String passwordInp = "palubinskasIrCo123";
            passwordIn.sendKeys(passwordInp);
            Thread.sleep(1000);
            // Įvedame asmeninius duomenis "Patvirtinti naują slaptažodį":
            WebElement newInput = driver.findElement(newPasswordInput);
            // Imam slaptažodį ir padidinam slaptažodžio paskutinyjį skaičių vienetu:
            // Terminologija: 'substring' pasiemą nurodyto slaptažodžio dalį (čia nuo indexo 0 iki skaičių)
            // 'Integer.parseInt' - verčiame žodinę srting reikšmę į int skaitinę reikšmę.
            String newPassword = passwordInp.substring(0, passwordInp.length() - 3) + (Integer.parseInt(passwordInp.
                    substring(passwordInp.length() - 3)) + 1);
            // Įvedam jau pamodifikuotą reikšmę į laukelį "Naujas slaptažodis"
            newInput.sendKeys(newPassword);
            // Įvedam jau pamodifikuotą reikšmę į laukelį "Patvirtinti naują slaptažodį"
            WebElement repeatedInput = driver.findElement(repeatedPasswordInput);
            repeatedInput.sendKeys(newPassword);
            // Spaudžiame mygtuką "Išsaugoti pakeitimus"
            WebElement saveChanButton = driver.findElement(saveChangesButton);
            saveChanButton.click();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // Paswordo atstatymas į pradinį, kad nereikėtų po kiekvieno testo atstatinėti ranka:
            // Scroll'inam 400 pikselių žemyn, kad pasimatytų laukeliai "KEISTI SLAPTAŽODĮ"
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(800);
            // Įvedame asmeninius duomenis "Esamas slaptažodis":
            WebElement passwordIn1 = driver.findElement(existingPasswordInput);
            passwordIn1.sendKeys(newPassword);
            // Įvedame asmeninius duomenis "Naujas slaptažodis":
            WebElement newInput1 = driver.findElement(newPasswordInput);
            newInput1.sendKeys(passwordInp);
            // Įvedame asmeninius duomenis "Patvirtinti naują slaptažodį":
            WebElement repeatInput1 = driver.findElement(repeatedPasswordInput);
            repeatInput1.sendKeys(passwordInp);
            // Spaudžiame mygtuką "Išsaugoti pakeitimus"
            WebElement saveChangesButton1 = driver.findElement(saveChangesButton);
            saveChangesButton1.click();
            // Spaudžiame mygtuką "Atsijungti"
            WebElement disconnect1 = driver.findElement(disconnect);
            disconnect1.click();
        } catch (Exception e) {
            System.out.println("Save Changes Button is not displayed");
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