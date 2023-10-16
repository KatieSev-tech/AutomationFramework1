package testcases;

import org.testng.annotations.Test;
import pageobjects.BaseMain;

public class EndToEndTestCase extends BaseTest {

    @Test(groups = {"scenario1"})
    public void historySectionAvailableForLoggedInUsers() {
        homePage.openCourseGalleryPage();
        courseGalleryPage.verifyHistoryIsNotPresentForSignedUsers();
        courseGalleryPage.returnToMainMenu();
        homePage.openSignInPage();
        loginPage.fillUpCredentials();
        loginPage.submitButtonCredentials();
        homePage.openCourseGalleryPage();
        courseGalleryPage.historyIsPresentForSignedUsers();
    }


    @Test(groups = {"scenario2"})
    public void allCourseGallerySectionsAreDisplayed() {
        homePage.openCourseGalleryPage();
        courseGalleryPage.expectedListOfSections();
        courseGalleryPage.listOfSectionsAreDisplayed();
        courseGalleryPage.verifyGalleryCourseSections();

    }


    @Test(groups = {"scenario3"})
    public void quizProgressFunctionality() throws InterruptedException {
        homePage.openCourseGalleryPage();
        courseGalleryPage.totalQuestionsInSQlBasics();
        courseGalleryPage.startSQLBasicsQuiz();
        baseMain.tabHandler(1);
        sql101BasicsQuiz.clickOnAnswer();
        sql101BasicsQuiz.actualValueOfProgress();
        sql101BasicsQuiz.expectedValueOfProgress();
        sql101BasicsQuiz.verifyValueOfProgress();
        sql101BasicsQuiz.clickOnNextQuestion();
        sql101BasicsQuiz.actualValueOfProgress();
        sql101BasicsQuiz.expectedValueOfProgress();
        sql101BasicsQuiz.verifyValueOfProgress();
        sql101BasicsQuiz.clickOnAnswer();
        sql101BasicsQuiz.actualValueOfProgress();
        sql101BasicsQuiz.expectedValueOfProgressAfterAnswer();
        sql101BasicsQuiz.verifyChangedValueOfProgress();

    }

}
