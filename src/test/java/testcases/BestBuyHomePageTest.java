package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.BaseTest;

public class BestBuyHomePageTest extends BaseTest {


    //verify suggested item section appears 4 times as user scrolls main page
    @Test
    public void TC123_SuggestItemSectionAppears4TimesOnMainPage(){
        bestBuyMainPage.openBestBuyMainPage();
        bestBuyMainPage.scrollAndWaitSuggestItemSectionAndVerifyCount();

    }
 @Test
    public void TC124_SuggestItemSectionAppearsNoMore4TimesOnMainPage(){
        bestBuyMainPage.openBestBuyMainPage();
        bestBuyMainPage.scrollAndWaitSuggestItemSectionAndVerifyCount();
        bestBuyMainPage.verifyNoMoreThan4SuggestedItemSections();

    }

  @Test
    public void ooo(){
      bestBuyMainPage.openBestBuyMainPage();
      bestBuyMainPage.verify();
  }
}
