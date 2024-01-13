package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.logging.Logger;

public class SignUpPage extends BaseMain {

    public SignUpPage(RemoteWebDriver driver, Logger log) {
        super(driver, log);
    }

    public String firstNameField = "name";
    public String nameInput = "Name";
    public String surnameField = "surname";
    public String surnameInput = "Surname";
    public String jobTitleField = "job-title";
    public String jobTitleQAAnalystDD = "//option[contains(text(),'QA Analyst, Software Tester')]";
    public String emailField = "email";
    public String emailInput = "test@gmail.com";
    public String passwordField = "password";
    public String passwordInput = "Password1234";
    public String passwordConfirmField = "password-confirm";
    public String rememberMeCheckBox = "auth-page-remember-me";
    public String authCheckBox = "auth-page-agree-terms";
    public String signUpButton = "//button[contains(text(),'Sign Up')]";


    public void fieldsAreDisplayed (){

        driver.findElement(By.id(firstNameField)).isDisplayed();
        driver.findElement(By.id(surnameField)).isDisplayed();
        driver.findElement(By.id(jobTitleField)).isDisplayed();
        driver.findElement(By.id(emailField)).isDisplayed();
        driver.findElement(By.id(passwordField)).isDisplayed();
        driver.findElement(By.id(rememberMeCheckBox)).isSelected();
        driver.findElement(By.id(authCheckBox)).isSelected();
        driver.findElement(By.xpath(signUpButton)).isDisplayed();
    }
    public void signUpNoAgree() {
        driver.findElement(By.id(firstNameField)).sendKeys(nameInput);
        driver.findElement(By.id(surnameField)).sendKeys(surnameInput);
        driver.findElement(By.xpath(jobTitleQAAnalystDD));
        driver.findElement(By.id(emailField)).sendKeys(emailInput);
        driver.findElement(By.id(passwordField)).sendKeys(passwordInput);
        driver.findElement(By.id(passwordConfirmField)).sendKeys(passwordInput);
        driver.findElement(By.xpath(signUpButton)).submit();


    }


}