package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseMain {

    String menuList = "//body[1]/div[1]/div[1]/div[1]/div[2]/a";
    int listSizeActual;
    int listSizeExpected = 4;
    String expectedTitle = "My Fork - your educational solution";
    String actualTitle;
    String socialsMenuList = "//body/div[@id='app']/div[3]/div[1]/a";
    int listSocialsListExpected = 3;
    int listSocialsListActual;


    public ChromeDriver driver;
    public Logger log;

    public BaseMain(ChromeDriver driver, Logger logger){

        this.driver =driver;
        this.log = logger;
    }

    public void hardAssertsOpenWebsite () {

        Assert.assertTrue(true, "open website url is right");
        List<WebElement> elementList = driver.findElements(By.xpath(menuList));
        listSizeActual = elementList.size();
        Assert.assertEquals(listSizeActual, listSizeExpected);
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        List<WebElement> socialsList = driver.findElements(By.xpath(socialsMenuList));
        listSocialsListActual = socialsList.size();
        Assert.assertEquals(listSocialsListActual, listSocialsListExpected, "missing social media icon");

    }

    public void tabHandler (int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }


    public void scrollingPage (int pixels){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");
    }

    public void clickUsingXpath (String xpath, String elementName){
        driver.findElement(By.xpath(xpath)).click();
        log.info("Element:" +elementName + "was successfully clicked");
    }

    public void typeUsingXpath (String xpath, String elementName, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        log.info("Value: "+ value + " was successfully entered into " + elementName + "element");
    }
    public void submitUsingXpath (String xpath, String elementName){
        driver.findElement(By.xpath(xpath)).submit();
        log.info("Element:" +elementName + "was successfully submitted");
    }

    public void validateStringWithAssertEqual (String actual, String expected){
        Assert.assertEquals(actual, expected);
        log.info(actual + "value of progress equal expected value of progress" + expected);
    }

}