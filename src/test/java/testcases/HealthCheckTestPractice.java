package testcases;

import org.testng.annotations.Test;

public class HealthCheckTestPractice extends BaseTest{
    @Test (groups = "patientRole", priority = 3)
    public void signInParticipant() {
        homePage.openSignInPage();
        loginPage.fillTheSignInForm("user1", "password1");
        }

    @Test(groups = "adminRole", priority = 3)
    public void signInAdmin(){
        homePage.openSignInPage();
        loginPage.fillTheSignInForm("admin1", "passwordAdmin1");
    }

    @Test(groups = "ownerRole, releaseSeptember", priority = 2) //if ownerRole include, release - exclude = method will be executed
    public void signInOwner(){
        homePage.openSignInPage();
        loginPage.fillTheSignInForm("owner1", "passwordOwner1");
    }

    @Test(priority = 1) //priority works within 1 current class
    public void homePageValidation(){
        homePage.openSignInPage();
    }

}
