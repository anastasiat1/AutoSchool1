package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constant;
import utils.Utils;

import java.util.List;

public class ProductPage extends BasicPage{

    public ProductPage() {
    }

    public void chooseRandomOffer(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constant.CLASSNAME_OFFERS_LIST)));
        List<WebElement> cartBtn = driver.findElements(By.className(Constant.CLASSNAME_OFFERS_LIST));
        cartBtn.get(Utils.chooseRandomElement(cartBtn)).click();
    }

    public CartPage openCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constant.ID_CART))).click();
        return new CartPage();
    }
}
