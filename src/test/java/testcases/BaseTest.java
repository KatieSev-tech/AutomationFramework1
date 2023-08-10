package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.*;

import java.time.Duration;

public class BaseTest {

    public ChromeDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    BestBuyMainPage bestBuyMainPage;
    CourseGalleryPage courseGalleryPage;
    SQL101BasicsQuiz sql101BasicsQuiz;
    BaseMain baseMain;

    @BeforeMethod(groups={"fields","links","webElements", "scenario1", "scenario2", "scenario3"}, alwaysRun = true) //all roles should be configured in any Before condition
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/katerynasevriukova/Documents/GitHub/SeleniumFramework/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        bestBuyMainPage = new BestBuyMainPage(driver);
        courseGalleryPage = new CourseGalleryPage(driver);
        sql101BasicsQuiz = new SQL101BasicsQuiz(driver);
        baseMain = new BaseMain(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    }

    @AfterMethod(groups={"fields","links","webElements","scenario1", "scenario2", "scenario3"}, alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
