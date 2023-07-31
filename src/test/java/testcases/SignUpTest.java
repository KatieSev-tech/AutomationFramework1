package testcases;

import org.testng.annotations.Test;
import pageobjects.BaseMain;

public class SignUpTest extends BaseTest {
    @Test(priority = 1, groups ={"links"})
    public void openSignUpPage (){
        homePage.openSignUpPage();
    }

    @Test(priority = 2, groups ={"fields"})
    public void allFieldsButtonsAreDisplayed () {
        homePage.openSignUpPage();
        signUpPage.fieldsAreDisplayed();
    }



    @Test(priority = 3, groups ={"webElements"})
    public void invalidSignUpNoAgreeCheckBox (){
        homePage.openSignUpPage();
        signUpPage.signUpNoAgree();
    }

}
