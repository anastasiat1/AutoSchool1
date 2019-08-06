package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasicPage {

    private static final String XPATH_LIST_PRODUCTS_IN_CART = "//div[contains(@class, 'cart-products')]";
    private static final String XPATH_CART_PRODUCT_INFO = ".//div[contains(@class,'cart-product-title')]";

    public List<WebElement> getProductsFromCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_LIST_PRODUCTS_IN_CART)));
        return driver.findElements(By.xpath(XPATH_LIST_PRODUCTS_IN_CART));
    }

    public boolean isProductPresent(List<WebElement> productsFromCart, String nameFromCatalog){
        boolean contains = false;
        for (WebElement productCart : productsFromCart) {
            String nameOfProductFromCart = productCart.findElement(By.xpath(XPATH_CART_PRODUCT_INFO)).getText();
            if (nameFromCatalog.contains(nameOfProductFromCart)) {
                contains = true;
            }
        }
        return contains;
    }
}