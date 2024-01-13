package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
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


    public RemoteWebDriver driver;
    public Logger log;

    public BaseMain(RemoteWebDriver driver, Logger logger){

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

    public List<Integer> verifyLinkActive(){

        List<WebElement> linkElements = driver.findElements(By.xpath("//a")); //collect all links from page
        List<String> collectedURLs = new ArrayList<>(); //this List will have actual URLs
        List<Integer> codes = new ArrayList<>(); //this List will have codes that each URL will return
        int resultCode; //initialize variable for a resulting code value and providing default value

       /* for (int i = 0; i < linkElements.size(); i++){
            collectedURLs.add(linkElements.get(i).getAttribute("href"));
        }
        */
        for (WebElement linkElement: linkElements){ //this loop takes each element from LinkElements and takes href attribute (since each item is a link it will have it)
            collectedURLs.add(linkElement.getAttribute("href"));
        }


        for(String collectedURL: collectedURLs) { // this loop will execute actions below to fill up codes List with actual values
            System.out.println("Starting verification of " + collectedURL);
            try { //making sure that exception won't fail the execution to carry execution on
                URL url = new URL(collectedURL); //initializes URL instance for provided URL
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection(); //initialize HTTP Connection
                httpURLConnect.setConnectTimeout(3000); //set timeout value
                httpURLConnect.connect(); //establish connection to provided URL to execute a call
                resultCode = httpURLConnect.getResponseCode(); //providing actual value into a value of a variable to be returned
                System.out.println(resultCode);
                codes.add(resultCode); //writing the result in resultCode array to return it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return codes; //a return of a list with codes for further verification
    }

}