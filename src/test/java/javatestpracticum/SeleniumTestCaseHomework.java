
package javatestpracticum;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SeleniumTestCaseHomework {


    @Test
        public void openWebsite(){
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/Documents/GitHub/SeleniumFramework/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");

    }

    @Test
        public void openSignInPage(){
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();

    }

    @Test
        public void validateEmailPasswordFieldsLoginButtonAreDisplayed (){
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        System.out.println(driver.findElement(By.id("email")).isDisplayed());
        System.out.println(driver.findElement(By.id("password")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//div[@id='loginButton']/button")).isDisplayed());

    }

    @Test
        public void validateInvalidEmailPasswordFieldsClickOnLoginButton (){
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.id("loginButton")).click();
    }

    @Test
        public void validateErrorIsAppeared (){
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.id("loginButton")).click();
        System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Error: email is incorrect')]")).isDisplayed());
    }

    @Test
        public void ValidateRememberMeCheckboxIsChecked (){
        System.setProperty("webdriver.chrome.driver","/Users/katerynasevriukova/IdeaProjects/SeleniumProject/src/test/resources/executables/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id='auth-page-remember-me']")).isSelected());
    }

}
