package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SQL101BasicsQuiz extends BaseMain {
    public SQL101BasicsQuiz(ChromeDriver driver) {
        super(driver);
    }

    String chosenAnswer = "//div[@id='quiz-process-question-block-answers-block']/div[1]";
    String unAnsweredQuestions = "//div[@class='quiz-process-questions-button ']";
    String nextButton = "//div[contains(text(),'Next')]";
    By progressBarValue = By.id("quiz-process-progress-data");

    public void clickOnAnswer(){
        driver.findElement(By.xpath(chosenAnswer)).click();
    }

    public void correctQuantityOfLeftQuestions() {
        List<WebElement> quantityOfLeftQuestions = driver.findElements(By.xpath(unAnsweredQuestions));
        System.out.println(quantityOfLeftQuestions);

    }

    public void clickOnNextQuestion(){
        driver.findElement(By.xpath(nextButton)).click();
    }


    public void validateValueOfpProgressBar(){
       driver.findElement(progressBarValue).getText();

    }
}
