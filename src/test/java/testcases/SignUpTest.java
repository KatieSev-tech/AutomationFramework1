package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.BaseMain;

import java.util.List;

public class SignUpTest extends BaseTest {
    @Test(priority = 1, groups ={"links"})
    public void openSignUpPage (){
        homePage.openSignUpPage();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
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
