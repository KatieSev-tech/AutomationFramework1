package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class CourseGalleryPage extends BaseMain {
    public CourseGalleryPage(ChromeDriver driver, Logger log) {
        super(driver, log );
    }

    public String historySection = "//div[@class='main-content']/a";
    public String expertiseList = "//div[@class='expertise-areas-list']/div";
    public String questionsCountTotal = "//div[@data-expertise-name='Development'][1]/div[2]/div[1]";
    public String startBtnSQlBasics = "//div[@data-expertise-name='Development']/div[2]/a[@href='/quiz/run/10']/div";
    public String logoImage = "//img[@id='logo']";

    public void historyIsPresentForSignedUsers() {

        Assert.assertFalse(historyIsNoTPresentForSignedUsers());
    }

    public void verifyHistoryIsNotPresentForSignedUsers() {
        Assert.assertTrue(historyIsNoTPresentForSignedUsers());
    }


    public boolean historyIsNoTPresentForSignedUsers() {
        try {
            driver.findElement(By.xpath(historySection)).isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;

        }
    }

    List<String> expectedGalleryCourseSections = Arrays.asList("Development", "Testing","Business Analysis", "Agile","Project Management");

    public List<String>actualListOfSections() {
        List<WebElement> allGalleryCourseSections = driver.findElements(By.xpath(expertiseList));
        List<String> actualGalleryCourseSections = new ArrayList<>();
        for (WebElement webElement : allGalleryCourseSections) {
            actualGalleryCourseSections.add(webElement.getText());
            System.out.println(actualGalleryCourseSections);
        }
        return actualGalleryCourseSections;
    }

    public void verifyGalleryCourseSections (List <String> actualList){
        Assert.assertEquals(actualList,expectedGalleryCourseSections);

    }

    public void returnToMainMenu(){
        clickUsingXpath(logoImage, "return to main page by clicking logo is successful");
        //driver.findElement(By.xpath(logoImage)).click();
}


    public String totalQuestionsInSQlBasics () {

        String totalQuestions = driver.findElement(By.xpath(questionsCountTotal)).getText();
        totalQuestions = totalQuestions.substring(4);
        System.out.println(totalQuestions);
        return totalQuestions;

    }

    public void startSQLBasicsQuiz () {
        clickUsingXpath(startBtnSQlBasics, "SLBasicsQuiz is started successfully");
        //driver.findElement(By.xpath(startBtnSQlBasics)).click();

        }



     /*public List<String> expectedListOfSections() {
        List<String> expectedGalleryElements = new ArrayList<>();
        expectedGalleryElements.add("Development");
        expectedGalleryElements.add("Testing");
        expectedGalleryElements.add("Business Analyst");
        expectedGalleryElements.add("Agile");
        expectedGalleryElements.add("Project Management");
        System.out.println(expectedGalleryElements);
        return expectedGalleryElements;


    }
*/
    }
