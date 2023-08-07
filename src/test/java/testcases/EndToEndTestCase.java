package testcases;

import org.testng.annotations.Test;
import pageobjects.BaseMain;

public class EndToEndTestCase extends BaseTest{

    @Test(groups = {"scenario1"})
    public void historySectionAvailableForLoggedInUsers () {
        homePage.openCourseGalleryPage();
        courseGalleryPage.historyIsNoTPresentForSignedUsers();
        courseGalleryPage.returnToMainMenu();
        homePage.openSignInPage();
        loginPage.fillUpCredentials();
        loginPage.submitButtonCredentials();
        homePage.openCourseGalleryPage();
        courseGalleryPage.historyIsPresentForSignedUsers();
        courseGalleryPage.softAssertionsHistorySectionIsDisplayed();
    }


    @Test(groups = {"scenario1"})
    public void allCourseGallerySectionsAreDisplayed (){
        homePage.openCourseGalleryPage();
        courseGalleryPage.developmentSectionIsPresent();
        courseGalleryPage.softAssertDevelopmentSectionIsPresent();
        courseGalleryPage.testingSectionIsPresent();
        courseGalleryPage.softAssertTestingSectionIsPresent();
        courseGalleryPage.businessAnalystSectionIsPresent();
        courseGalleryPage.softAssertBusinessAnalystSectionIsPresent();
        courseGalleryPage.agileSectionIsPresent();
        courseGalleryPage.softAssertAgileSectionIsPresent();
        courseGalleryPage.projectManagementSectionIsPresent();
        courseGalleryPage.softAssertProjectManagementSectionIsPresent();
    }


    @Test(groups = {"scenario1"})
    public void quizProgressFunctionality (){
        homePage.openCourseGalleryPage();
        courseGalleryPage.totalQuestionsInSQlBasics();
        courseGalleryPage.startSQLBasicsQuiz();
        baseMain.tabHandler(2);
        sql101BasicsQuiz.clickOnAnswer();
        sql101BasicsQuiz.correctQuantityOfLeftQuestions();
        sql101BasicsQuiz.clickOnNextQuestion();
        sql101BasicsQuiz.validateValueOfpProgressBar();

    }

}
