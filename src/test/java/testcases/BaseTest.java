package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignUpPage;
import java.time.Duration;

public class BaseTest {

    public ChromeDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/katerynasevriukova/Documents/GitHub/SeleniumFramework/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
