package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class BestBuySearchResultsPage extends BaseMain{
    public BestBuySearchResultsPage (ChromeDriver driver) {

        super(driver);
    }

    private By searchItemTitle = By.xpath("//h4[@class='sku-title']/a");
    private By addToCardButton = By.xpath("//button[@data-button-state='ADD_TO_CART']");
    private By customerPriceTag =By.xpath("//div[@data-testid='large-price-view']//div[@data-testid='customer-price']");
    private By cartSubtotalText = By.xpath("//div[@class='sub-total v-fw-medium']");
    private By cartSubtotalWindowButtonClose = By.xpath("//button[@data-track='Attach Modal: Close']");

    public String searchItemTitleText(int searchResultRow){
        return driver.findElements(searchItemTitle).get(searchResultRow).getText();
    }
    private String customerPriceTagText(int searchResultRow){
        return driver.findElements(customerPriceTag).get(searchResultRow).getText();
    }
    private void addItemToCartFromRow (int searchResultRow){
        driver.findElements(addToCardButton).get(searchResultRow).click();
    }

    public int searchItemTitleCount(){
        return driver.findElements(searchItemTitle).size();
    }


    public void verifySearchItemTitleTextContainsQuery(int searchResultRow, String expected){
        /*String title = searchItemTitleText (2).toUpperCase();
        String expected = "blender";
        expected = expected.toUpperCase();
        System.out.println(title);
        Assert.assertTrue(title.contains(expected.toUpperCase()));*/
        System.out.println(searchResultRow);
      //  Assert.assertTrue(searchItemTitleText (searchResultRow).toUpperCase().contains(expected.toUpperCase()));

    }
    public void clickAddToCartButton (){
        driver.findElement(addToCardButton).click();
    }

    private String modalWindowCartPrice(){
        String price = driver.findElement(cartSubtotalText).getText();
        return price.substring(1);

    }
    public List<String> addItemToCart_And_returnPrice(){
        String firstItemPrice = customerPriceTagText(0); //private method "customerPriceTagText" in method
        System.out.println(firstItemPrice);
        firstItemPrice =firstItemPrice.substring(1,firstItemPrice.indexOf("\n")); //print without $ -1 removed sign, \n-everything removed from next line
        String secondItemPrice = customerPriceTagText(1);
        secondItemPrice =secondItemPrice.substring(1,secondItemPrice.indexOf("\n"));


        double firstItemPriceDouble =Double.parseDouble(firstItemPrice);
        double secondItemPriceDouble =Double.parseDouble(secondItemPrice);

        System.out.println(firstItemPrice + secondItemPrice);
        System.out.println(firstItemPriceDouble + secondItemPriceDouble);

        addItemToCartFromRow(0);  //private method "addItemToCartFromRow" in method
        Assert.assertEquals(modalWindowCartPrice(), firstItemPrice);
        closeModal();

        addItemToCartFromRow(1);
        String expectedSubtotal = String.valueOf(firstItemPriceDouble + secondItemPriceDouble);
        System.out.println(expectedSubtotal);
        Assert.assertEquals(modalWindowCartPrice(), expectedSubtotal);

        return null;
    }


    private void closeModal (){
        driver.findElement(cartSubtotalWindowButtonClose).click();
    }
}
