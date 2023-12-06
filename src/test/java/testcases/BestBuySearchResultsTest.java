package testcases;

import org.testng.annotations.Test;

public class BestBuySearchResultsTest extends BaseTest{

    @Test

    public void TC212_ModalWindowPriceAddVerification() {
        bestBuyMainPage.openBestBuyMainPage();
        String query = "blender";
        bestBuyMainPage.searchFor(query);
        for (int i = 0; i < bestBuySearchResultsPage.searchItemTitleCount(); i++) {
            bestBuySearchResultsPage.verifySearchItemTitleTextContainsQuery(i, query);

        }
        bestBuySearchResultsPage.addItemToCart_And_returnPrice();


    }


}
