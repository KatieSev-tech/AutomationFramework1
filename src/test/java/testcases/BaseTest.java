package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.*;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {

    public ChromeDriver driver;
    Logger log;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    BestBuyMainPage bestBuyMainPage;
    CourseGalleryPage courseGalleryPage;
    SQL101BasicsQuiz sql101BasicsQuiz;
    BaseMain baseMain;
    BestBuySearchResultsPage bestBuySearchResultsPage;

    @BeforeMethod(groups={"fields","links","webElements", "scenario1", "scenario2", "scenario3"}, alwaysRun = true) //all roles should be configured in any Before condition
    public void SetUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/katerynasevriukova/Documents/Automation/AutomationFramework/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        log = Logger.getLogger(getClass().getName());
        saveLogs(log);
        homePage = new HomePage(driver, log);
        loginPage = new LoginPage(driver, log);
        signUpPage = new SignUpPage(driver, log);
        bestBuyMainPage = new BestBuyMainPage(driver, log);
        courseGalleryPage = new CourseGalleryPage(driver, log);
        sql101BasicsQuiz = new SQL101BasicsQuiz(driver, log);
        bestBuySearchResultsPage = new BestBuySearchResultsPage(driver, log);
        baseMain = new BaseMain(driver, log);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    }

    @AfterMethod(groups={"fields","links","webElements","scenario1", "scenario2", "scenario3"}, alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
    public void saveLogs(Logger log) throws IOException {
        FileHandler fileHandler;
        fileHandler = new FileHandler("/Users/katerynasevriukova/Documents/Automation/AutomationFramework/Mylogs.log");
        this.log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        this.log.info("This is a beginning of test suit");

    }
}
