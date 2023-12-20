package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import pageobjects.*;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {

    public  RemoteWebDriver driver;
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
    public void startDriver (@Optional("chrome") String browser ) throws IOException {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/katerynasevriukova/Documents/Automation/AutomationFramework/src/test/resources/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
           System.setProperty("webdriver.gecko.driver", "/Users/katerynasevriukova/Documents/Automation/AutomationFramework/src/test/resources/geckodriver");
           driver = new FirefoxDriver();
        }
        log = Logger.getLogger(getClass().getName());
        saveLogs(log);
        homePage = new HomePage((ChromeDriver) driver, log);
        loginPage = new LoginPage((ChromeDriver) driver, log);
        signUpPage = new SignUpPage((ChromeDriver) driver, log);
        bestBuyMainPage = new BestBuyMainPage((ChromeDriver) driver, log);
        courseGalleryPage = new CourseGalleryPage((ChromeDriver) driver, log);
        sql101BasicsQuiz = new SQL101BasicsQuiz((ChromeDriver) driver, log);
        bestBuySearchResultsPage = new BestBuySearchResultsPage((ChromeDriver) driver, log);
        baseMain = new BaseMain((ChromeDriver) driver, log);

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
