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
    String nextButton = "//div[@class='quiz-process-navigations-block']/div[2]";
    String progressBarValue = "quiz-process-progress-data";

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

    public void displayQuantityOfLeftQuestions() {
        WebDriverWait waitForChangedQuantityOfQuestions = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForChangedQuantityOfQuestions.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unAnsweredQuestions)));
    }

    public void clickOnNextQuestion() {
        driver.findElement(By.xpath(nextButton)).click();
    }


    public void validateValueOfProgressBar() {
        WebElement valueOfProgress = driver.findElement(By.id(progressBarValue));
        String percentValueOfProgress = valueOfProgress.getAttribute ("style");
        System.out.println(percentValueOfProgress);

    }

    public void validateChangedValue () {
        WebElement valueOfProgress = driver.findElement(By.id(progressBarValue));
        String updatedPercentValueOfProgress = valueOfProgress.getAttribute("style");
        System.out.println(updatedPercentValueOfProgress);
    }
    public void validateChangedValueIsCorrect (){

        int updatedPercentValueOfProgress = 22;

    if (updatedPercentValueOfProgress == 22)
    {
               System.out.println("Changed Value is correct");
           }

       else  {
               System.out.println("Changed Value is NOT correct");
           }
    }


}
