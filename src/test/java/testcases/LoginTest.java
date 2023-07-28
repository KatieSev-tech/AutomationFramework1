
package testcases;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void signInPage(){

        homePage.openSignInPage();
    }
    @Test
    public void validateEmailPasswordFieldsLoginButtonAreDisplayed (){

        homePage.openSignInPage();
        loginPage.emailPasswordFieldsSignInButtonAreDisplayed();
        loginPage.softAssertionsSignInPageFields();

    }

    @Test
    public void validateInvalidEmailPasswordFieldsClickOnLoginButton (){

        homePage.openSignInPage();
        loginPage.fillUpInvalidCredentials();
        loginPage.submitButtonCredentials();
    }

    @Test
    public void validateErrorIsAppeared (){

        homePage.openSignInPage();
        loginPage.fillUpInvalidCredentials();
        loginPage.submitButtonCredentials();
        loginPage.displayErrorMessage();
        loginPage.softAssertionsErrorMessageText();
    }

    @Test
    public void ValidateRememberMeCheckboxIsChecked (){

        homePage.openSignInPage();
        loginPage.checkIfRememberMeIsSelected();
    }

    @Test
    public void validateCheckBoxTextIsDisplayed () {
        homePage.openSignInPage();
        loginPage.checkBoxTextIsDisplayed();
        loginPage.softAssertionsSignInPageRememberMeText();
    }


    @Test
    public void validateSignUplinkIsDisplayed (){
        homePage.openSignInPage();
        loginPage.SignUpLinkIsPresent();
        loginPage.softAssertionsSignInPageSignUpLink();
    }

    @Test
    public void validateValidEmailPasswordClickLoginButton () {
        homePage.openSignInPage();
        loginPage.fillUpCredentials();
        loginPage.submitButtonCredentials();
    }


}