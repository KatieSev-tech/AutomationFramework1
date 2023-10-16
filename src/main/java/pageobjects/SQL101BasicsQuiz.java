package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SQL101BasicsQuiz extends BaseMain {
    public SQL101BasicsQuiz(ChromeDriver driver) {
        super(driver);
    }

    String chosenAnswer = "//div[@id='quiz-process-question-block-answers-block']/div[1]";
    String totalQuestions = "//div[@class='quiz-process-questions']/div[9]";
    String answered1Question = "//div[@class='quiz-process-questions-button answered']";
    String answered2question = "//div[@class='quiz-process-questions']/div[2]";
    String nextButton = "//div[contains(@class,'quiz-process-navigations-block-button-next')]";
    String progressBarValue = "//div[@id='quiz-process-progress-data']";
    public String questionsCountTotal = "//div[@data-expertise-name='Development'][1]/div[2]/div[1]";
    double percent = 100;

    public void clickOnAnswer() {
        driver.findElement(By.xpath(chosenAnswer)).click();
    }

    public void correctQuantityOfUnansweredQuestions() {
        List<WebElement> quantityOfLeftQuestions = driver.findElements(By.xpath(totalQuestions));
        int listOfUnansweredQuestions = quantityOfLeftQuestions.size();
        System.out.println(listOfUnansweredQuestions);

    }

    public void clickOnNextQuestion() throws InterruptedException {
        driver.findElement(By.xpath(nextButton));
        Thread.sleep(4000);
        driver.findElement(By.xpath(nextButton)).click();
    }

    public String actualValueOfProgress(){
        WebElement valueOfProgress = driver.findElement(By.xpath(progressBarValue));
        String percentValueOfProgress = valueOfProgress.getText();
        //System.out.println(percentValueOfProgress);
        percentValueOfProgress = percentValueOfProgress.substring(0,2);
        System.out.println(percentValueOfProgress);
        return percentValueOfProgress;
    }


    public String expectedValueOfProgress() {
        String AnsweredQuestions = driver.findElement(By.xpath(answered1Question)).getText();
        //System.out.println(AnsweredQuestions);
        String generalQuestions = driver.findElement(By.xpath(totalQuestions)).getText();
        //System.out.println(generalQuestions);
        double AnsweredQuestionsValue = Double.parseDouble(AnsweredQuestions);
        //System.out.println(AnsweredQuestionsValue);
        double totalQuestions = Double.parseDouble(generalQuestions);
       // System.out.println(totalQuestions);
        double correctValueOfProgress = (AnsweredQuestionsValue * percent) / totalQuestions;
        //System.out.println(correctValueOfProgress);
        String expectedValueOfProgress = String.valueOf(correctValueOfProgress);
        //System.out.println(expectedValueOfProgress);
        expectedValueOfProgress =  expectedValueOfProgress.substring(0,2);
        System.out.println(expectedValueOfProgress);
        return expectedValueOfProgress;

    }

    public void verifyValueOfProgress(){
        Assert.assertEquals(actualValueOfProgress(), expectedValueOfProgress());
    }

    public String expectedValueOfProgressAfterAnswer() {
        String AnsweredQuestions = driver.findElement(By.xpath(answered2question)).getText();
        //System.out.println(AnsweredQuestions);
        String generalQuestions = driver.findElement(By.xpath(totalQuestions)).getText();
        //System.out.println(generalQuestions);
        double AnsweredQuestionsValue = Double.parseDouble(AnsweredQuestions);
        //System.out.println(AnsweredQuestionsValue);
        double totalQuestions = Double.parseDouble(generalQuestions);
        // System.out.println(totalQuestions);
        double correctValueOfProgress = (AnsweredQuestionsValue * percent) / totalQuestions;
        //System.out.println(correctValueOfProgress);
        String expectedValueOfProgress = String.valueOf(correctValueOfProgress);
        //System.out.println(expectedValueOfProgress);
        expectedValueOfProgress =  expectedValueOfProgress.substring(0,2);
        System.out.println(expectedValueOfProgress);
        return expectedValueOfProgress;

    }
    public void verifyChangedValueOfProgress() {
        Assert.assertEquals(actualValueOfProgress(), expectedValueOfProgressAfterAnswer());
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
