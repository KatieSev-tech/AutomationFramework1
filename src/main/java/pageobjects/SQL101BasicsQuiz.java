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
    String unAnsweredQuestions = "//div[@class='quiz-process-questions-button ']";
    String answeredQuestions = "//div[@class='quiz-process-questions-button answered']";
    String nextButton = "//div[contains(@class,'quiz-process-navigations-block-button-next')]";
    String progressBarValue = "quiz-process-progress-data";
    int percentOfProgress = 11;

    public void clickOnAnswer() {
        driver.findElement(By.xpath(chosenAnswer)).click();
    }

    public void correctQuantityOfUnansweredQuestions() {
        List<WebElement> quantityOfLeftQuestions = driver.findElements(By.xpath(unAnsweredQuestions));
        int listOfUnansweredQuestions = quantityOfLeftQuestions.size();
        System.out.println(listOfUnansweredQuestions);

    }
    public void hardAssertQuantityOfAnsweredQuestions (){
        Assert.assertTrue(true, "every number of question becomes gray");
        List<WebElement> quantityOfAnsweredQuestions = driver.findElements(By.xpath(answeredQuestions));
        int listOfAnsweredQuestions = quantityOfAnsweredQuestions.size();
        System.out.println(listOfAnsweredQuestions);
    }

    /* public void displayQuantityOfLeftQuestions() {
        WebDriverWait waitForChangedQuantityOfQuestions = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForChangedQuantityOfQuestions.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unAnsweredQuestions)));
    }
    */


    public void clickOnNextQuestion() throws InterruptedException {
        driver.findElement(By.xpath(nextButton));
        Thread.sleep(4000);
        driver.findElement(By.xpath(nextButton)).click(); ////nextButton = "div[@class='quiz-process-navigations-block']/div[2]"
    }


    public void validateNotChangedValueOfProgressBar() {
        WebElement valueOfProgress = driver.findElement(By.id(progressBarValue));
        String percentValueOfProgress = valueOfProgress.getText();
       // percentValueOfProgress = percentValueOfProgress.substring(3);
        System.out.println(percentValueOfProgress);
       Assert.assertEquals(percentValueOfProgress, "11%" );

    }

   /* public void validateChangedValue () {
        WebElement valueOfProgress = driver.findElement(By.id(progressBarValue));
        String updatedPercentValueOfProgress = valueOfProgress.getText();
        System.out.println(updatedPercentValueOfProgress);
    }
    */

    public void validateChangedValueIsCorrect () {

        String AnsweredQuestionPercent = driver.findElement(By.id(progressBarValue)).getText();
        AnsweredQuestionPercent = AnsweredQuestionPercent.substring(3);

        int AnsweredQuestionPercentValueInteger = Integer.parseInt(AnsweredQuestionPercent);
        System.out.println(AnsweredQuestionPercentValueInteger);
        Assert.assertEquals(AnsweredQuestionPercentValueInteger + "%", 22 + "%");
    }

}

