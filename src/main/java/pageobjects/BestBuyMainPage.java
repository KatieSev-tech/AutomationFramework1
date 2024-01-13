package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class BestBuyMainPage extends BaseMain {
    public BestBuyMainPage(RemoteWebDriver driver, Logger log) {

        super(driver, log);
    }

    String domain = "https://www.bestbuy.com/";
    //String URL = domain + "/login";
    By suggestItemSection = By.xpath("//ul[@class='c-carousel-list']");
    By searchField = By.xpath("//input[@id='gh-search-input']");
    By searchButton = By.xpath("//button[@title='submit search']");



    public void openBestBuyMainPage () {
       driver.get(domain);
    }

    public int suggestItemSectionCount(){
        return driver.findElements(suggestItemSection).size();
    }

    public void scrollAndWaitSuggestItemSectionAndVerifyCount(){
        verifySuggestedItemSectionCount(1);
        for (int i =2; i < 5; i++) {
            System.out.println("currently we expect: "+i);
            scrollingPage(1500);
            waitSuggestedItemSection(i);
            verifySuggestedItemSectionCount(i);
        }

//        scrollingPage(1500);  command "/" - all lines of code
//        waitSuggestedItemSection(2);
//        verifySuggestedItemSectionCount(2);
//
//         scrollingPage(1500);
//        waitSuggestedItemSection(3);
//        verifySuggestedItemSectionCount(3);
//
//        scrollingPage(1500);
//        waitSuggestedItemSection(4);
//        verifySuggestedItemSectionCount(4);
    }

    public void verifyNoMoreThan4SuggestedItemSections(){
        Assert.assertTrue(suggestItemSectionCount()<5);
    }

    public void waitSuggestedItemSection(int expectedNumber){
        WebDriverWait waitItemSection = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitItemSection.until(ExpectedConditions.numberOfElementsToBe(suggestItemSection, expectedNumber));


    }
    public void verifySuggestedItemSectionCount(int expected){
        Assert.assertEquals(suggestItemSectionCount(), expected);
    }

    public void verify() {
        Assert.assertTrue(sss());
    }
    public boolean sss(){
        try {
            System.out.println("execution goes here");
            driver.findElement(suggestItemSection);
            return false;
        }
        catch (NoSuchElementException e){
            System.out.println("if exception raised we end up here");
            return true;
        }
    }

    public void ooo(){
    List<WebElement> list = driver.findElements(suggestItemSection);
    Assert.assertTrue(list.isEmpty());
    }
 public void searchFor(String query){
        try{
           // WebDriverWait
            driver.findElement(By.id("closeButton")).click();
        }
        catch (NoSuchElementException e){

        }
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchButton).click();
 }

}

