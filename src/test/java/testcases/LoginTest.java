
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LoginTest extends BaseTest{

    @Test(priority = 1, groups = {"links"})
    public void signInPage(){

        homePage.openSignInPage();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
            softAssert.assertAll();
        }
    }
    @Test(priority = 1, groups = {"fields"})
    public void validateEmailPasswordFieldsLoginButtonAreDisplayed (){

        homePage.openSignInPage();
        loginPage.emailPasswordFieldsSignInButtonAreDisplayed();
        loginPage.softAssertionsSignInPageFields();

    }

    @Test(priority = 2, groups = {"fields"})
    public void validateInvalidEmailPasswordFieldsClickOnLoginButton (){

        homePage.openSignInPage();
        loginPage.fillUpInvalidCredentials();
        loginPage.submitButtonCredentials();
    }

    @Test(priority = 3, groups ={"fields"})
    public void validateErrorIsAppeared (){

        homePage.openSignInPage();
        loginPage.fillUpInvalidCredentials();
        loginPage.submitButtonCredentials();
        loginPage.displayErrorMessage();
        loginPage.softAssertionsErrorMessageText();
    }

    @Test(priority = 2, groups ={"webElements"})
    public void ValidateRememberMeCheckboxIsChecked (){
        homePage.openSignInPage();
        loginPage.checkIfRememberMeIsSelected();
    }

    @Test(priority = 2, groups = {"webElements"})
    public void validateCheckBoxTextIsDisplayed () {
        homePage.openSignInPage();
        loginPage.checkBoxTextIsDisplayed();
        loginPage.softAssertionsSignInPageRememberMeText();
    }


    @Test(priority = 2, groups = {"webElements"})
    public void validateSignUplinkIsDisplayed (){
        homePage.openSignInPage();
        loginPage.SignUpLinkIsPresent();
        loginPage.softAssertionsSignInPageSignUpLink();
    }

    @Test(priority = 2, groups = {"webElements"})
    public void validateValidEmailPasswordClickLoginButton () {
        homePage.openSignInPage();
        loginPage.fillUpCredentials();
        loginPage.submitButtonCredentials();
    }


}