package pageobjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Logger;

public class HomePage extends BaseMain{

    BaseMain baseMain = new BaseMain(driver, log); // should provide value to avoid null error

    public HomePage( ChromeDriver driver, Logger log){
        super(driver, log);
    }
    // @FindBy page factoring organization
    public String myForkURL = "https://test.my-fork.com/";
    public String SignInButton = "//div[@id='log-in-button']/..";
    public String SignUpButton = "//div[@id='sign-up-button']/..";
    public String CourseGalleryButton = "//div[text()='Course Gallery']/..";

    public void openSignInPage(){

        driver.get(myForkURL);
        baseMain.hardAssertsOpenWebsite();
        clickUsingXpath(SignInButton, "SignIn page is opened successfully");
        //driver.findElement(By.xpath(SignInButton)).click();

    }

    public void openSignUpPage(){
        driver.get(myForkURL);
        clickUsingXpath(SignUpButton, "SignUp page is opened successfully");
        //driver.findElement(By.xpath(SignUpButton)).click();
    }

    public void openCourseGalleryPage(){
        driver.get(myForkURL);
        clickUsingXpath(CourseGalleryButton, "CourseGallery page is opened successfully");
        //driver.findElement(By.xpath(CourseGalleryButton)).click();
    }

    public List<Integer> urlVerification(){

        return verifyLinkActive();
    }
}