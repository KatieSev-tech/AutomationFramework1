package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BaseMain{

    public LoginPage(ChromeDriver driver){
        super(driver);
    }

    public String EmailField = "email";
    public String passwordField = "password";
    private String validEmail = "katietest@gmail.com";
    private String validPassword = "Password1006!";
    private String invalidEmail = "test@gmail.com";
    private String invalidPassword = "password";
    public String LogInButtonLoginPage = "//button[@type ='submit']";
    public String ErrorWrongEmail = "//p[contains(text(),'Error: email is incorrect')]";
    public String RememberMeCheckBox = "//input[@id='auth-page-remember-me']";
    public String CheckBoxText = "//div[contains(text(),'Remember Me')]";

    public String loginFieldsList = "//body/div[@id='app']/div[1]/div[2]/div/p";
    int loginsFieldsListActual;
    int loginsFieldsListExpected = 3;
    public String signUpButton = "//a[contains(text(),'Sign Up')]";

    public void fillUpCredentials (){
        driver.findElement(By.id(EmailField)).sendKeys(validEmail);
        driver.findElement(By.id(passwordField)).sendKeys(validPassword);

    }

    public void fillUpInvalidCredentials (){
        driver.findElement(By.id(EmailField)).sendKeys(invalidEmail);
        driver.findElement(By.id(passwordField)).sendKeys(invalidPassword);
    }

    public void emailPasswordFieldsSignInButtonAreDisplayed (){
        driver.findElement(By.id(EmailField)).isDisplayed();
        driver.findElement(By.id(passwordField)).isDisplayed();
        driver.findElement(By.xpath(LogInButtonLoginPage)).isDisplayed();
    }

    public void submitButtonCredentials (){

        driver.findElement(By.xpath(LogInButtonLoginPage)).click();
    }

    public void displayErrorMessage (){
        WebDriverWait waitForErrorMessage = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitForErrorMessage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ErrorWrongEmail)));
        driver.findElement(By.xpath(ErrorWrongEmail)).getText();
    }

    public void checkIfRememberMeIsSelected (){

        driver.findElement(By.xpath(RememberMeCheckBox)).isSelected();
    }

    public void checkBoxTextIsDisplayed (){

        driver.findElement(By.xpath(CheckBoxText)).isDisplayed();
    }

    public void SignUpLinkIsPresent (){
        driver.findElement(By.xpath(signUpButton));
    }

    public void softAssertionsSignInPageRememberMeText () {

        SoftAssert softAssert = new SoftAssert(); //add library manually through maven in "more" option

        WebElement rememberMeText = driver.findElement(By.xpath(CheckBoxText));
        softAssert.assertEquals(rememberMeText.getText(), "Remember Me");
    }


    public void softAssertionsSignInPageSignUpLink () {
        SoftAssert softAssert = new SoftAssert();
        WebElement signUpLink = driver.findElement(By.xpath(signUpButton));
        softAssert.assertEquals(signUpLink.getText(), "Sign up button");
        softAssert.assertAll();
    }

    public void softAssertionsSignInPageFields (){
        SoftAssert softAssert = new SoftAssert(); //add library manually through maven in "more" option
        List<WebElement> loginsFieldsList = driver.findElements(By.xpath(loginFieldsList));
        loginsFieldsListActual = loginsFieldsList.size();
        softAssert.assertEquals(loginsFieldsListActual, loginsFieldsListExpected);

        WebElement loginButton = driver.findElement(By.xpath(LogInButtonLoginPage));
        String loginButtonTitle = loginButton.getText();
        softAssert.assertTrue(loginButtonTitle.contains("Log In"), "Log In title is right");
        softAssert.assertAll();
    }


    public void softAssertionsErrorMessageText (){
        SoftAssert softAssert = new SoftAssert();
        WebElement errorMessage = driver.findElement(By.xpath(ErrorWrongEmail));
        String errorMessageText = errorMessage.getText();
        softAssert.assertEquals(errorMessageText,"Wrong password");
        softAssert.assertFalse(errorMessageText.contains("Wrong password"), "Wrong email should displayed");
        softAssert.assertAll();


    }
}