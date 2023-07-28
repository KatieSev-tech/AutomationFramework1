package testcases;

import org.testng.annotations.Test;
import pageobjects.BaseMain;

public class SignUpTest extends BaseTest {
    @Test
    public void openSignUpPage (){
        homePage.openSignUpPage();
    }

    @Test
    public void allFieldsButtonsAreDisplayed () {
        homePage.openSignUpPage();
        signUpPage.fieldsAreDisplayed();
    }



    @Test
    public void invalidSignUpNoAgreeCheckBox (){
        homePage.openSignUpPage();
        signUpPage.signUpNoAgree();
    }

}
