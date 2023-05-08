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

public class ChangePasword extends BasePage{

    // RASTI BUG'ai: - Nėra informacinių pranešimų ar pavyko atnaujinti profilio duomenis.

    //  changePasword / atstatyri Pasword:
    private static final By myAccountEdit = By.cssSelector(".account-link.account-login");
    private static final By nameInput = By.cssSelector("input[name='account_first_name']");
    private static final By surNameInput = By.cssSelector("input[name='account_last_name']");
    private static final By existingPasswordInput = By.cssSelector("input[name='password_current']");
    //private static final By showPasswordEye = By.cssSelector("");
    private static final By newPasswordInput = By.cssSelector("input[name='password_1']");
    private static final By repeatedPasswordInput = By.cssSelector("input[name='password_2']");
    private static final By saveChangesButton = By.cssSelector("button[value='Išsaugoti pakeitimus']");
    public ChangePasword() {
        super(driver);
    }


    // Pakeisti slaptažodį ir jį atstatyti:
    public static void changePasword() throws IOException {


        WebDriverWait myAccountEditWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement myAccount = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountEdit));
            myAccount.click();

            WebElement nameIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
            String nameIn1 = "Skirmantas";
            nameIn.sendKeys(nameIn1);

            WebElement surnameIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(surNameInput));
            String surIn1 = "Skirmantas";
            surnameIn.sendKeys(surIn1);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(800);

            WebElement passwordIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(existingPasswordInput));
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
        } catch (Exception e) {
            System.out.println("Save Changes Button is not displayed");
        }
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }
}
