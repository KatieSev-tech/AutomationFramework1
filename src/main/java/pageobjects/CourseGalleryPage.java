package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class CourseGalleryPage extends BaseMain {
    public CourseGalleryPage(ChromeDriver driver) {
        super(driver);
    }

    public String historySection = "/html[1]/body[1]/div[1]/div[2]/a[1]";
    public String topMenuBlock = "/html[1]/body[1]/div[1]/div[2]";
    public String developmentMenu = "//div[contains(text(),'Development')]";
    public String testingMenu = "//div[contains(text(),'Testing')]";
    public String businessAnalystMenu = "//div[contains(text(),'Business Analyst')]";
    public String agileMenu = "//div[contains(text(),'Agile')]";
    public String projectManagementMenu = "//div[contains(text(),'Project Management')]";
    public String LogoLink = "//img[@id='logo']/..";
    public String questionsCountTotal = "//div[@class='quiz-item-bottom-block']/a";
    public String startBtnSQlBasics ="//body/div[@id='app']/div[2]/div[3]/div[2]/div[2]/a[1]/div[1]";

    public void historyIsPresentForSignedUsers() {
        driver.findElement(By.xpath(historySection));
    }

    public void historyIsNoTPresentForSignedUsers() {
        driver.findElement(By.xpath(topMenuBlock));
    }


    public void developmentSectionIsPresent() {

        driver.findElement(By.xpath(developmentMenu));
    }

    public void testingSectionIsPresent() {

        driver.findElement(By.xpath(testingMenu));
    }

    public void businessAnalystSectionIsPresent() {

        driver.findElement(By.xpath(businessAnalystMenu));
    }

    public void agileSectionIsPresent() {

        driver.findElement(By.xpath(agileMenu));
    }

    public void projectManagementSectionIsPresent() {

        driver.findElement(By.xpath(projectManagementMenu));
    }


    public void softAssertionsHistorySectionIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> historyMenu = driver.findElements(By.xpath(historySection));
        String historyMenuLink = driver.getCurrentUrl();
        boolean historyLink = historyMenuLink.contains("/statistic/list");
        softAssert.assertTrue(historyLink);
        softAssert.assertAll();

    }

    public void softAssertDevelopmentSectionIsPresent() {
        SoftAssert softAssert = new SoftAssert();
        WebElement developmentSection = driver.findElement(By.xpath(developmentMenu));
        softAssert.assertEquals((developmentSection.getText()), "Development");
        softAssert.assertAll();
    }

    public void softAssertTestingSectionIsPresent() {
        SoftAssert softAssert = new SoftAssert();
        WebElement testingSection = driver.findElement(By.xpath(testingMenu));
        softAssert.assertEquals((testingSection.getText()), "Testing");
        softAssert.assertAll();
    }

    public void softAssertBusinessAnalystSectionIsPresent() {
        SoftAssert softAssert = new SoftAssert();
        WebElement BusinessAnalystSection = driver.findElement(By.xpath(businessAnalystMenu));
        softAssert.assertEquals((BusinessAnalystSection.getText()), "Business Analyst");
        softAssert.assertAll();
    }

    public void softAssertAgileSectionIsPresent() {
        SoftAssert softAssert = new SoftAssert();
        WebElement AgileSection = driver.findElement(By.xpath(businessAnalystMenu));
        softAssert.assertEquals((AgileSection.getText()), "Agile");
        softAssert.assertAll();
    }

    public void softAssertProjectManagementSectionIsPresent() {
        SoftAssert softAssert = new SoftAssert();
        WebElement ProjectManagementSection = driver.findElement(By.xpath(businessAnalystMenu));
        softAssert.assertEquals((ProjectManagementSection.getText()), "Project Management");
        softAssert.assertAll();
    }

    public void returnToMainMenu() {
        driver.findElement(By.xpath(LogoLink)).click();
    }

    public void totalQuestionsInSQlBasics() {

        List<WebElement> totalNumberQuestionsSQLBasics = driver.findElements(By.xpath(questionsCountTotal));
        int totalQuestionsCount = totalNumberQuestionsSQLBasics.size();
        System.out.println(totalQuestionsCount);

    }

    public void startSQLBasicsQuiz (){
        driver.findElement(By.xpath(startBtnSQlBasics)).click();

    }
}

