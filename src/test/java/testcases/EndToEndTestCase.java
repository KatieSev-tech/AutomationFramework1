package testcases;

import org.testng.annotations.Test;
import pageobjects.BaseMain;

public class EndToEndTestCase extends BaseTest {

    @Test(groups = {"scenario1"})
    public void historySectionAvailableForLoggedInUsers() {
        homePage.openCourseGalleryPage();
        courseGalleryPage.historyIsNoTPresentForSignedUsers();
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
        courseGalleryPage.listOfSectionsAreDisplayed();


    }


    @Test(groups = {"scenario3"})
    public void quizProgressFunctionality() throws InterruptedException {
        homePage.openCourseGalleryPage();
        courseGalleryPage.totalQuestionsInSQlBasics();
        courseGalleryPage.startSQLBasicsQuiz();
        baseMain.tabHandler(1);
        sql101BasicsQuiz.clickOnAnswer();
        sql101BasicsQuiz.correctQuantityOfUnansweredQuestions();
        sql101BasicsQuiz.hardAssertQuantityOfAnsweredQuestions();
        sql101BasicsQuiz.clickOnNextQuestion();
        sql101BasicsQuiz.validateNotChangedValueOfProgressBar();
        sql101BasicsQuiz.clickOnAnswer();
        sql101BasicsQuiz.validateChangedValueIsCorrect();

    }

}
