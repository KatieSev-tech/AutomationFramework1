package testcases;

import org.testng.annotations.Test;
import pageobjects.BaseMain;

import java.util.List;

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
        List<String> actualList = courseGalleryPage.actualListOfSections();
        courseGalleryPage.verifyGalleryCourseSections(actualList);

    }


    @Test(groups = {"scenario3"})
    public void quizProgressFunctionality() throws InterruptedException {
        homePage.openCourseGalleryPage();
        String tQuestions = courseGalleryPage.totalQuestionsInSQlBasics();
        courseGalleryPage.startSQLBasicsQuiz();
        baseMain.tabHandler(1);
        sql101BasicsQuiz.clickOnAnswer();
        String actual = sql101BasicsQuiz.actualValueOfProgress();
        String expected = sql101BasicsQuiz.expectedValueOfProgress(tQuestions);
        sql101BasicsQuiz.verifyValueOfProgress(actual, expected);
        sql101BasicsQuiz.clickOnNextQuestion();
        actual = sql101BasicsQuiz.actualValueOfProgress();
        expected = sql101BasicsQuiz.expectedValueOfProgress(tQuestions);
        sql101BasicsQuiz.verifyValueOfProgress(actual, expected);
        sql101BasicsQuiz.clickOnAnswer();
        actual = sql101BasicsQuiz.actualValueOfProgress();
        expected =sql101BasicsQuiz.expectedValueOfProgressAfterAnswer(tQuestions);
        sql101BasicsQuiz.verifyChangedValueOfProgress(actual, expected);

    }

}
