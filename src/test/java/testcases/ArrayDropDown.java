package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.reporters.AbstractXmlReporter;

import java.util.ArrayList;
import java.util.List;

public class ArrayDropDown extends BaseTest{


    @Test(priority = 2, groups ={"webElements"})

    public void jobTitleDropdown () {
        homePage.openSignUpPage();
        WebElement jobTitleDropdownElement;
        jobTitleDropdownElement = driver.findElement(By.id("job-title"));
        Select jobTDropdownElement = new Select(jobTitleDropdownElement);
        List<WebElement> options = new ArrayList<>();
        options = jobTDropdownElement.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
    }
}