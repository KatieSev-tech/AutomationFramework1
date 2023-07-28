package javatestpracticum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import testcases.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class DriverInteractions extends BaseTest {

    @Test
    public void test1() {  //command + D copy and paste
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("prime deals");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        String urlToVerify = driver.getCurrentUrl();
        System.out.println(urlToVerify);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

    } @Test
    public void test2() {
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("prime deals");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        String urlToVerify = driver.getCurrentUrl();
        System.out.println(urlToVerify);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

    }
    @Test
        public void test3() {
        driver.get("https://www.amazon.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles()); //intializes list, 2 result
        System.out.println(tabHandler.size());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        tabHandler = new ArrayList<>(driver.getWindowHandles()); //update list,  5 result
        System.out.println(tabHandler.size());
        driver.switchTo().window(tabHandler.get(0));
        driver.switchTo().window(tabHandler.get(4)); // 5th tab
        driver.navigate().to("https://www.bestbuy.com/");
//        driver.switchTo().alert().accept(); //button "ok"
//        driver.switchTo().alert().getText(); //check some text in open pop up
//        driver.switchTo().alert().sendKeys(); // provide information
//        driver.switchTo().alert().dismiss(); //cancel pop up window

    }

    @Test
    public void test4() {
        driver.get("https://www.amazon.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", ""); // scroll down page
        js.executeScript("window.scrollBy(0,-1000)", "");//scroll up the page


    }

    @Test
    public void tabSwitching (int tab) {
        driver.get("https://www.amazon.com/");
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
        System.out.println(tabHandler);
    }

        public void main(String[] args) {
        int tab = 1;
        tabSwitching(tab);
        int tab1 = 2;
        tabSwitching(tab1);
        int tab2 = 3;
        tabSwitching(tab2);
        int tab3 = 4;
        tabSwitching(tab3);
    }

}
