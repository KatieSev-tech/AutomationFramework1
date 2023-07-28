package javatestpracticum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.BaseTest;

import java.util.List;

public class Assertions extends BaseTest {

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

        Assert.assertEquals(actualTitle, expectedTitle);  //fail point, and test will not move execute other lines of code
        System.out.println("title is correct");

        Assert.assertNotEquals(actualTitle, expectedTitle);
        System.out.println("title is different");

        List<WebElement> elementList = driver.findElements(By.xpath(menuList));
        listSizeActual = elementList.size();

        Assert.assertEquals(listSizeActual, listSizeExpected, "titles are not the same");


    }
}
