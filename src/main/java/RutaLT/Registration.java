package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration extends BasePage{

    // acceptCookie:
    private static final By cookieButton = By.cssSelector("div[class='cookies-holder'] button:nth-child(2)");
    private static final By iframe = By.id("ml-webforms-popup-5855857");
    private static final By popUps = By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/button");
    // registrations:
    private static final By myAccountButton = By.xpath("/html/body/div[1]/header/div/div[3]/div/div[4]/ul/li[2]/a");
    private static final By regEmail = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[2]/div/form/p[1]/input");
    private static final By registruotisButton = By.cssSelector("button[value='Registruotis']");
    private static final By atsijungtiButton = By.cssSelector("ul[class='account-nav nav nav-line nav-uppercase nav-vertical mt-half'] li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout'] a");
    // logingIn:
    private static final By prisijungtiEmailInput = By.cssSelector("input[name='username']");
    private static final By prisijungtiPasswordInput = By.cssSelector("input[name='password']");
    private static final By prisijungtiButton = By.cssSelector("button[value='Prisijungti']");
    //  changePasword / atstatyri Pasword:
    private static final By myAccountEdit = By.cssSelector(".account-link.account-login");
    private static final By vardasInput = By.cssSelector("input[name='account_first_name']");
    private static final By pavardeInput = By.cssSelector("input[name='account_last_name']");
    private static final By esamasSlaptazodisInput = By.cssSelector("input[name='password_current']");
    //private static final By esamSlaptEye = By.cssSelector("body > div:nth-child(11) > main:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > fieldset:nth-child(5) > p:nth-child(2) > span:nth-child(2) > span:nth-child(2)");
    private static final By naujasSlaptazodisInput = By.cssSelector("input[name='password_1']");
    private static final By pakartotasSlaptazodisInput = By.cssSelector("input[name='password_2']");
    private static final By issaugotipakeitimusButton = By.cssSelector("button[value='Išsaugoti pakeitimus']");

    public Registration() {
        super(driver);
    }

    public static void acceptCookie() {
        WebDriverWait popUpWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement cookieAccept = driver.findElement(cookieButton);
            cookieAccept.click();


            FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);

            WebElement popUpElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(popUps));
            if(popUpElement.isDisplayed()){
                System.out.println("popUp is visible.");
            }else{
                System.out.println("popUp is not visible.");
            }

//            fluentWait.until(ExpectedConditions.elementToBeClickable(popUps)).click();

        } catch (Exception e) {
        System.out.println("PopUp not displayd");
    }

}
    public static void registrations(){
        WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountButton));
            accountButton.click();

            WebElement emailField = driver.findElement(regEmail); //emailInput(){
//        String emailData = "skirmantas.skirmantas@yahoo.com";
            String emailData = "skirman.skirmat@yahoo.com";
            emailField.sendKeys(emailData);

            WebElement registrButton = driver.findElement(registruotisButton);
            registrButton.click();

            WebElement atsijungtButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(atsijungtiButton));
            atsijungtButton.click();

        }catch (Exception e){
            System.out.println("My account Button is not found. ");
        }

    }
    public static void logingIn(){
        WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountButton));
            accountButton.click();
        }catch (Exception e){
            System.out.println("My account Button is not found. ");
        }
        try {
            WebElement emailField = driver.findElement(prisijungtiEmailInput);
            String emailData = "skirmantas.skirmantas@yahoo.com";
            emailField.sendKeys(emailData);

            WebElement passwordIn = driver.findElement(prisijungtiPasswordInput);
            String passwordInp = "palubinskasIrCo123";
            passwordIn.sendKeys(passwordInp);
            Thread.sleep(1000);

            WebElement prisijunkButton = driver.findElement(prisijungtiButton);
            prisijunkButton.click();

        }catch (Exception e){
            System.out.println("Prisijungti button not found.");
        }
    }

    // Pakeisti slaptažodį ir jį atstatyti:
    public static void changePasword(){
        WebDriverWait myAccountEditWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement myAccount = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountEdit));
            myAccount.click();

            WebElement vardasIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(vardasInput));
            String vardasIn1 ="Skirmantas";
            vardasIn.sendKeys(vardasIn1);

            WebElement pavardeIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(pavardeInput));
            String pavardeIn1 = "Skirmantas";
            pavardeIn.sendKeys(pavardeIn1);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(800);

            WebElement passwordIn = myAccountEditWait.until(ExpectedConditions.visibilityOfElementLocated(esamasSlaptazodisInput));
            String passwordInp = "palubinskasIrCo123";
            passwordIn.sendKeys(passwordInp);
            Thread.sleep(1000);

            WebElement naujasInput = driver.findElement(naujasSlaptazodisInput);
            String naujasSlap = passwordInp.substring(0, passwordInp.length() - 3) + (Integer.parseInt(passwordInp.substring(passwordInp.length() - 3)) + 1);
            naujasInput.sendKeys(naujasSlap);

            WebElement pakartotasInput = driver.findElement(pakartotasSlaptazodisInput);
            pakartotasInput.sendKeys(naujasSlap);

            WebElement issaugotipakeitButton = driver.findElement(issaugotipakeitimusButton);
            issaugotipakeitButton.click();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Paswordo atstatymas į pradinį:

            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(800);

            WebElement passwordIn1 = driver.findElement(esamasSlaptazodisInput);
            passwordIn1.sendKeys(naujasSlap);

            WebElement naujasInput1 = driver.findElement(naujasSlaptazodisInput);
            naujasInput1.sendKeys(passwordInp);

            WebElement pakartotasInput1 = driver.findElement(pakartotasSlaptazodisInput);
            pakartotasInput1.sendKeys(passwordInp);

            WebElement issaugotipakeitButton1 = driver.findElement(issaugotipakeitimusButton);
            issaugotipakeitButton1.click();
        }catch (Exception e){
            System.out.println("Išsaugoti pakeitimus Button is not displayed");
        }

    }
}
