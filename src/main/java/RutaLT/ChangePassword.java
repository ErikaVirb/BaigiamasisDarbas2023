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


        WebDriverWait myAccountEditWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement myAccount = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated
                    (myAccountEdit));
            myAccount.click();
//            String emailField = "skirmantas.skirmantas@yahoo.com";
//            WebElement email1 = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(email));
//            String emailValue = email1.getText();
//            System.out.println(emailValue);
//
//            if(emailField.equals(emailValue)){
//                System.out.println("The email field value and the text value are the same.");
//            }else {
//                System.out.println("The email field value and the text value are different.");
//            }
            WebElement nameIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
            String nameIn1 = "Skirmantas";
            nameIn.sendKeys(nameIn1);
            WebElement surnameIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(surNameInput));
            String surIn1 = "Skirmantas";
            surnameIn.sendKeys(surIn1);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(800);
            WebElement passwordIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated
                    (existingPasswordInput));
            String passwordInp = "palubinskasIrCo123";
            passwordIn.sendKeys(passwordInp);
            Thread.sleep(1000);
            WebElement newInput = driver.findElement(newPasswordInput);
            String newPassword = passwordInp.substring(0, passwordInp.length() - 3) + (Integer.parseInt(passwordInp.
                    substring(passwordInp.length() - 3)) + 1);
            newInput.sendKeys(newPassword);
            WebElement repeatedInput = driver.findElement(repeatedPasswordInput);
            repeatedInput.sendKeys(newPassword);
            WebElement saveChanButton = driver.findElement(saveChangesButton);
            saveChanButton.click();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // Paswordo atstatymas į pradinį:
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(800);
            WebElement passwordIn1 = driver.findElement(existingPasswordInput);
            passwordIn1.sendKeys(newPassword);
            WebElement newInput1 = driver.findElement(newPasswordInput);
            newInput1.sendKeys(passwordInp);
            WebElement repeatInput1 = driver.findElement(repeatedPasswordInput);
            repeatInput1.sendKeys(passwordInp);
            WebElement saveChangesButton1 = driver.findElement(saveChangesButton);
            saveChangesButton1.click();
            WebElement disconnect1 = driver.findElement(disconnect);
            disconnect1.click();
        } catch (Exception e) {
            System.out.println("Save Changes Button is not displayed");
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