package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.logging.Logger;

public class SQL101BasicsQuiz extends BaseMain {
    public SQL101BasicsQuiz(RemoteWebDriver driver, Logger log) {

        super(driver, log);
    }

    String chosenAnswer = "//div[@id='quiz-process-question-block-answers-block']/div[1]";
    String totalQuestions = "//div[@class='quiz-process-questions']/div";
    String answeredQuestion = "//div[@class='quiz-process-questions-button answered']";

    String nextButton = "//div[contains(@class,'quiz-process-navigations-block-button-next')]";
    String progressBarValue = "//div[@id='quiz-process-progress-data']";
    public String questionsCountTotal = "//div[@data-expertise-name='Development'][1]/div[2]/div[1]";
    double percent = 100;

    public void clickOnAnswer() {
        clickUsingXpath(chosenAnswer, "Answer field is chosen successfully");
        //driver.findElement(By.xpath(chosenAnswer)).click();
    }


    public void clickOnNextQuestion() throws InterruptedException {
        driver.findElement(By.xpath(nextButton));
        Thread.sleep(4000);
        clickUsingXpath(nextButton, "NextQuestionPage is opened successful");
        //driver.findElement(By.xpath(nextButton)).click();
    }

    public String actualValueOfProgress(){
        String valueOfProgress = driver.findElement(By.xpath(progressBarValue)).getText();
        int indexOfPercent = valueOfProgress.indexOf("%");
        valueOfProgress = valueOfProgress.substring(0,indexOfPercent);
        System.out.println(valueOfProgress);
        return valueOfProgress;
    }


    public String expectedValueOfProgress(String tQuestions) {
        int AnsweredQuestions = driver.findElements(By.xpath(answeredQuestion)).size();
        System.out.println(AnsweredQuestions);
        String passedQuestions = String.valueOf(AnsweredQuestions);
        double AnsweredQuestionsValue = Double.parseDouble(passedQuestions);
        //System.out.println(AnsweredQuestionsValue);
        double totalQuestions = Double.parseDouble(tQuestions);
        //System.out.println(totalQuestions);
        double correctValueOfProgress = (AnsweredQuestionsValue * percent) / totalQuestions;
        //System.out.println(correctValueOfProgress);
        String expectedValueOfProgress = String.valueOf(correctValueOfProgress);
        //System.out.println(expectedValueOfProgress);
        int indexOfDot = expectedValueOfProgress.indexOf(".");
        expectedValueOfProgress =  expectedValueOfProgress.substring(0,indexOfDot);
        //System.out.println(expectedValueOfProgress);
        return expectedValueOfProgress;

    }

    public void verifyValueOfProgress(String actual, String expected){
        validateStringWithAssertEqual(actual, expected);
        //Assert.assertEquals(actual, expected);
    }




    /* public void validateNotChangedValueOfProgressBar() {
        WebElement valueOfProgress = driver.findElement(By.xpath(progressBarValue));
        String percentValueOfProgress = valueOfProgress.getText();
        percentValueOfProgress = percentValueOfProgress.substring(3);

        System.out.println(percentValueOfProgress);
        Assert.assertEquals(percentValueOfProgress, "11%");

    }

    public void validateChangedValue () {
        WebElement valueOfProgress = driver.findElement(By.id(progressBarValue));
        String updatedPercentValueOfProgress = valueOfProgress.getText();
        System.out.println(updatedPercentValueOfProgress);
    }


    public void hardAssertQuantityOfAnsweredQuestions() {
        Assert.assertTrue(true, "every number of question becomes gray");
        List<WebElement> quantityOfAnsweredQuestions = driver.findElements(By.xpath(answeredQuestions));
        int listOfAnsweredQuestions = quantityOfAnsweredQuestions.size();
        System.out.println(listOfAnsweredQuestions);

     public void displayQuantityOfLeftQuestions() {
        WebDriverWait waitForChangedQuantityOfQuestions = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForChangedQuantityOfQuestions.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unAnsweredQuestions)));
    }
    */

}
