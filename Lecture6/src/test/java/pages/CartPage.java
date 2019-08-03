package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constant;

import java.util.List;

public class CartPage extends BasicPage {

    public CartPage() {
    }

    public List<WebElement> getProductsFromCart() {
        return driver.findElements(By.className(Constant.CLASSNAME_LIST_PRODUCTS_IN_CART));
    }

    public WebElement getProductInfoFromCart(){
        return driver.findElement(By.xpath(Constant.XPATH_CART_PRODUCT_INFO));
    }
}
