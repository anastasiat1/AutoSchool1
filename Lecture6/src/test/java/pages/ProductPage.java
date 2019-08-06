package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

import java.util.List;

public class ProductPage extends BasicPage{

    private static final String CLASSNAME_OFFERS_LIST = "offers-list__button_basket";
    private static final String ID_CART = "cart-desktop";

    public void chooseRandomOffer(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(CLASSNAME_OFFERS_LIST)));
        List<WebElement> cartBtn = driver.findElements(By.className(CLASSNAME_OFFERS_LIST));
        cartBtn.get(Utils.getRandomIndex(cartBtn)).click();
    }

    public CartPage openCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_CART))).click();
        return new CartPage();
    }
}