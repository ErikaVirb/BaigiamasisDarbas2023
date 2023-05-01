package RutaLT;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration extends BasePage{

    private static final By cookieButton = By.cssSelector("div[class='cookies-holder'] button:nth-child(2)");
    private static final By myAccountButton = By.xpath("/html/body/div[1]/header/div/div[3]/div/div[4]/ul/li[2]/a");
    private static final By regEmail = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[2]/div/form/p[1]/input");
    private static final By registruotisButton = By.cssSelector("button[value='Registruotis']");
    private static final By atsijungtiButton = By.cssSelector("ul[class='account-nav nav nav-line nav-uppercase nav-vertical mt-half'] li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout'] a");
    private static final By prisijungtiEmailInput = By.cssSelector("input[name='username']");
    private static final By prisijungtiPasswordInput = By.cssSelector("input[name='password']");
    private static final By prisijungtiButton = By.cssSelector("button[value='Prisijungti']");
    private static final By myAccountEdit = By.cssSelector(".account-link.account-login");
    private static final By vardasInput = By.cssSelector("input[name='account_first_name']");
    private static final By pavardeInput = By.cssSelector("input[name='account_last_name']");
    private static final By esamasSlaptazodisInput = By.cssSelector("input[name='password_current']");
    //private static final By esamSlaptEye = By.cssSelector("body > div:nth-child(11) > main:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > fieldset:nth-child(5) > p:nth-child(2) > span:nth-child(2) > span:nth-child(2)");
    private static final By naujasSlaptazodisInput = By.cssSelector("input[name='password_1']");
    private static final By pakartotasSlaptazodisInput = By.cssSelector("input[name='password_2']");

    public Registration() {
        super(driver);
    }

    public static void acceptCookie(){
        WebElement cookieAccept = driver.findElement(cookieButton);
        cookieAccept.click();
    }
    public static void registrations(){
        WebDriverWait myAccounWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement accountButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(myAccountButton));
            accountButton.click();
        }catch (Exception e){
            System.out.println("My account Button is not found. ");
        }
        WebElement emailField = driver.findElement(regEmail); //emailInput(){
//        String emailData = "skirmantas.skirmantas@yahoo.com";
        String emailData = "skirman.skirman@yahoo.com";
        emailField.sendKeys(emailData);

        WebElement registrButton = driver.findElement(registruotisButton);
        registrButton.click();

        WebElement atsijungtButton = myAccounWait.until(ExpectedConditions.visibilityOfElementLocated(atsijungtiButton));
        atsijungtButton.click();
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
///////////////////////////////////
//            WebElement slaptEye = driver.findElement(esamSlaptEye);
//            Actions action = new Actions(driver);
//            action.moveToElement(slaptEye).click();
///////////////////////////////////
            WebElement naujasInput = driver.findElement(naujasSlaptazodisInput);
            String naujasSlap = passwordInp.substring(0, passwordInp.length() - 3) + (Integer.parseInt(passwordInp.substring(passwordInp.length() - 3)) + 1);
            naujasInput.sendKeys(naujasSlap);

            WebElement pakartotasInput = driver.findElement(pakartotasSlaptazodisInput);
            pakartotasInput.sendKeys(naujasSlap);



        }catch (Exception e){
            System.out.println("Naujas slaptazodis Input is not displayed");
        }

    }
}
