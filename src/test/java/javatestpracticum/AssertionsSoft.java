package javatestpracticum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testcases.BaseTest;

import java.util.List;

public class AssertionsSoft extends BaseTest {

    String expectedTitle = "Clinic";
    String actualTitle;
    String menuList = "//body/div[@id='a-page']/div[@id='apex-content-container']/div[@id='conditions']/div[1]/pui-section[3]/pui-tab-container[1]/ul[1]/li";
    int listSizeActual;
    int listSizeExpected = 8;

    //Hard Assertions = asserts which fail the test
    @Test
    public void titles () {
        driver.get("https://clinic.amazon.com/?nodl=0&ref_=nav_cs_clinic");
        actualTitle = driver.getTitle();
        List<WebElement> elementList = driver.findElements(By.xpath(menuList));
        listSizeActual = elementList.size();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle, "titles are not the same");
        softAssert.assertNotEquals(actualTitle, expectedTitle);
        softAssert.assertEquals(listSizeActual, listSizeExpected, "lists size ids different");
        softAssert.assertAll(); // return all the problems, messages but does not fail test right after first fail code line, fail and collects after passing all the lines of code

    }

}
