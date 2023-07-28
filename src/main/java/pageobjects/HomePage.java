package pageobjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseMain{

    BaseMain baseMain = new BaseMain(driver); // should provide value to avoid null error

    public HomePage(ChromeDriver driver){
        super(driver);
    }
    // @FindBy page factoring organization
    public String myForkURL = "https://test.my-fork.com/";
    public String SignInButton = "//div[@id='log-in-button']/..";
    public String SignUpButton = "//div[@id='sign-up-button']/..";

    public void openSignInPage(){

        driver.get(myForkURL);
        baseMain.hardAssertsOpenWebsite();
        driver.findElement(By.xpath(SignInButton)).click();

    }

    public void openSignUpPage(){
        driver.get(myForkURL);
        driver.findElement(By.xpath(SignUpButton)).click();
    }
}