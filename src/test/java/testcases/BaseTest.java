package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageobjects.*;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
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
    @Parameters("browser")
    public void startDriver (@Optional("sauce-chrome") String browser ) throws IOException {
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

        else if (browser.equalsIgnoreCase("sauce-chrome")) {

            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest"); //"latest-1"
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-katie.sevriukova-ed608");
            sauceOptions.put("accessKey", "1e4a12ed-c9c5-461c-a98c-631105fe61be");
            sauceOptions.put("build", "selenium-build-OEQIV");
            sauceOptions.put("name", "First Sauce test");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"); // url- is sauceLab server
            driver = new RemoteWebDriver(url, browserOptions);
        }
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
