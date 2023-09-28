package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
    public String logoLink = "//img[@id = 'home-my-fork-logo']/..";

    public void historyIsPresentForSignedUsers() {
        driver.findElement(By.xpath(historySection)).isDisplayed();
    }

    public void historyIsNoTPresentForSignedUsers() {
        driver.findElement(By.xpath(topMenuBlock));
        try {
            driver.findElement(By.xpath(historySection)).isDisplayed();
            System.out.println("History section is present - test fails");
        } catch (NoSuchElementException exception) {
            System.out.println("No history section  - test passes");
        }
    }

    public void listOfSectionsAreDisplayed() {
        List<WebElement> allGalleryCourseSections = driver.findElements(By.xpath(expertiseList)); //expertiseList = "//div[@class='expertise-areas-list']/div"
        int allGalleryCourseElements = allGalleryCourseSections.size();
        for (WebElement webElement : allGalleryCourseSections) {
            String allGalleryCourseElement = webElement.getText();
            System.out.println(allGalleryCourseElement);
            Assert.assertEquals(allGalleryCourseElement, "Development" +
                    " Testing" +
                    " Business Analyst" +
                    " Agile" +
                    "Project " +
                    "Management");
        }

    }
   /* public void listOfSectionsContainsProvidedText(){

        List<WebElement> elements = driver.findElements(By.xpath(expertiseList));

        elements.stream().anyMatch(e->e.getText().trim().contains("Development, Testing, Business Analyst, Agile, Project Management"));

        System.out.println(elements);
       }
    public void sectionsContainProvidedText(){

            Assert.assertEquals(driver.findElement(By.xpath("developmentMenu")).getText(), "Development");
            Assert.assertEquals(driver.findElement(By.xpath("testingMenu")).getText(), "Testing");
            Assert.assertEquals(driver.findElement(By.xpath("businessAnalystMenu")).getText(), "Business Analyst");
            Assert.assertEquals(driver.findElement(By.xpath("agileMenu")).getText(), "Agile");
            Assert.assertEquals(driver.findElement(By.xpath("projectManagementMenu")).getText(), "Project Management");

    }
*/

    public void returnToMainMenu() {
        driver.findElement(By.xpath(logoLink)).click();
    }


        /*

    public void totalQuestionsInSQlBasics () {

            List<WebElement> totalNumberQuestionsSQLBasics = driver.findElements(By.xpath(questionsCountTotal));
            int totalQuestionsCount = totalNumberQuestionsSQLBasics.size();
            System.out.println(totalQuestionsCount);

        }
        */
        public void totalQuestionsInSQlBasics () {

            String totalQuestions = driver.findElement(By.xpath(questionsCountTotal)).getText();
            totalQuestions = totalQuestions.substring(4);
            System.out.println(totalQuestions);

        }

        public void startSQLBasicsQuiz () {
            driver.findElement(By.xpath(startBtnSQlBasics)).click();

        }


    }
