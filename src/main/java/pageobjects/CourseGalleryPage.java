package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CourseGalleryPage extends BaseMain {
    public CourseGalleryPage(ChromeDriver driver) {
        super(driver);
    }

    public String historySection = "//div[@class='main-content']/a";
    public String expertiseList = "//div[@class='expertise-areas-list']/div";
    public String topMenuBlock = "/html[1]/body[1]/div[1]/div[2]";
    public String developmentMenu = "//div[@class='expertise-areas-list']/div[1]";
    public String testingMenu = "//div[@class='expertise-areas-list']/div[2]";
    public String businessAnalystMenu = "//div[@class='expertise-areas-list']/div[3]";
    public String agileMenu = "//div[@class='expertise-areas-list']/div[4]";
    public String projectManagementMenu = "//div[@class='expertise-areas-list']/div[5]";
    public String questionsCountTotal = "//div[@data-expertise-name='Development'][1]/div[2]/div[1]";
    public String startBtnSQlBasics = "//body/div[@id='app']/div[2]/div[3]/div[2]/div[2]/a[1]/div[1]";
    public String logoLink = "//img[@id='logo']";

    public void historyIsPresentForSignedUsers() {

        // driver.findElement(By.xpath(historySection)).isDisplayed();
        Assert.assertFalse(historyIsNoTPresentForSignedUsers());
    }

    public void verifyHistoryIsNotPresentForSignedUsers() {
        Assert.assertTrue(historyIsNoTPresentForSignedUsers());
    }


    public boolean historyIsNoTPresentForSignedUsers() {
        boolean isDisplayed;

        try {
            isDisplayed = driver.findElement(By.xpath(historySection)).isDisplayed();
            isDisplayed = false;
            return false;
        } catch (NoSuchElementException e) {
            isDisplayed = true;
            return true;

        }
    }

    public List<String> expectedListOfSections() {
        List<String> expectedGalleryElements = new ArrayList<>();
        expectedGalleryElements.add("Development");
        expectedGalleryElements.add("Testing");
        expectedGalleryElements.add("Business Analyst");
        expectedGalleryElements.add("Agile");
        expectedGalleryElements.add("Project Management");
        System.out.println(expectedGalleryElements);
        return expectedGalleryElements;


    }

    public List<String>listOfSectionsAreDisplayed() {
        List<WebElement> allGalleryCourseSections = driver.findElements(By.xpath(expertiseList));
        List<String> actualGalleryCourseSections = new ArrayList<>();
        for (WebElement webElement : allGalleryCourseSections) {
            actualGalleryCourseSections.add(webElement.getText());
            System.out.println(actualGalleryCourseSections);
        }
        return actualGalleryCourseSections;
    }


    public void verifyGalleryCourseSections (){
        Assert.assertEquals(listOfSectionsAreDisplayed(),expectedListOfSections());


    }

    public void returnToMainMenu(){
        driver.findElement(By.xpath(logoLink)).click();
}


    public void totalQuestionsInSQlBasics () {

        String totalQuestions = driver.findElement(By.xpath(questionsCountTotal)).getText();
        totalQuestions = totalQuestions.substring(4);
        System.out.println(totalQuestions);

        }

    public void startSQLBasicsQuiz () {
        driver.findElement(By.xpath(startBtnSQlBasics)).click();

        }
    }
