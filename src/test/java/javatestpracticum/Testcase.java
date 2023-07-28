
package javatestpracticum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Testcase {
    @Test
    public void startBrowser(){
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/Documents/GitHub/SeleniumFramework/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.thebroad.org/");

    }
    @Test
    public void openWebsite(){
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.bestbuy.com/");

    }

    @Test
    public void openSignInPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.bestbuy.com/");
        driver.findElement(By.xpath("//span[text()='Account']")).click();
//        Thread.sleep(1000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); below code inside method will be 50 within this method, all above 20 like pointed in BeforeMethod
        WebDriverWait waitForDropdownToLoad = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitForDropdownToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-lid='ubr_mby_signin_b']")));
        driver.findElement(By.xpath("//a[@data-lid='ubr_mby_signin_b']")).click();

    }

    @Test
    public void fillEmailAndPasswordFieldsAndSubmit () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.bestbuy.com/");

        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@data-lid='ubr_mby_signin_b']")).click();

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("email@gmail.com");
        driver.findElement(By.xpath("// input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Sign In']")).submit();

    }

    @Test
    public void fillEmailAndPasswordFieldsandPressEnter () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.bestbuy.com/");

        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@data-lid='ubr_mby_signin_b']")).click();

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("email@gmail.com");
        driver.findElement(By.xpath("// input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("// input[@type='password']")).sendKeys(Keys.ENTER);

    }

    @Test
    public void fillEmailAndPasswordFieldsandValidateError () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.bestbuy.com/");

        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@data-lid='ubr_mby_signin_b']")).click();

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("email@gmail.com");
        driver.findElement(By.xpath("// input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("// input[@type='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//div[@aria-label='Error']")).isDisplayed());

    }

    @Test
    public void fillEmailAndPasswordFieldsandValidateCheckbox () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.bestbuy.com/");

        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@data-lid='ubr_mby_signin_b']")).click();
        System.out.println(driver.findElement(By.id("cia-remember-me")).isSelected());

    }
    @Test
    public void VerifyCheckboxText () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.bestbuy.com/");

        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@data-lid='ubr_mby_signin_b']")).click();
        System.out.println(driver.findElement(By.xpath("//label[@for='cia-remember-me']")).getText());


    }

 @Test
    public void isEnabled () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG");
        driver.findElement(By.xpath("//h3[text()='Everyday Banking']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//button[text()='Cancel' and @href='javascript:void(0);']")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//button[@id='nextBtnSubTopic']")).isEnabled());



    }


}
