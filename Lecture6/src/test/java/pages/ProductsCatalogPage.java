package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import buisnessObjects.Product;
import utils.Utils;

import java.util.List;

public class ProductsCatalogPage extends BasicPage{

    private static final String CLASSNAME_GROUPS_OF_PRODUCTS = "schema-product__group";
    private static final String XPATH_CATALOG_PRODUCT_NAME = "//span[@data-bind='html: product.extended_name || product.full_name']";
    private static final String XPATH_PRODUCT = "//a[@class=\"schema-product__button button button_orange\"]";

    public ProductPage chooseRandomProductFromCatalog(){
        List<WebElement> products = driver.findElements(By.className(CLASSNAME_GROUPS_OF_PRODUCTS));
        WebElement product = products.get(Utils.getRandomIndex(0, products.size()-1));
        String nameElement = product.findElement(By.xpath(XPATH_CATALOG_PRODUCT_NAME)).getText();
        Product.createObject(nameElement);
        product.findElement(By.xpath(XPATH_PRODUCT)).click();
        return new ProductPage();
    }
}