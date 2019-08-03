package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constant;
import utils.Utils;

import java.util.List;

public class ProductsCatalogPage extends BasicPage{

    public ProductsCatalogPage() {
    }

    private WebElement chooseRandomProductFromCatalog(){
        List<WebElement> products = driver.findElements(By.className(Constant.CLASSNAME_GROUPS_OF_PRODUCTS));
        WebElement product = products.get(Utils.chooseRandomElement(products));
        return product;
    }

    public String getNameOfProductFromCatalog(){
        WebElement nameElement = chooseRandomProductFromCatalog().findElement(By.xpath(Constant.XPATH_CATALOG_PRODUCT_NAME));
        return nameElement.getText();
    }

    public ProductPage getRandomProductFromCatalog(){
        WebElement productBtn = chooseRandomProductFromCatalog().findElement(By.xpath(Constant.XPATH_PRODUCT));
        productBtn.click();
        return new ProductPage();
    }


}
