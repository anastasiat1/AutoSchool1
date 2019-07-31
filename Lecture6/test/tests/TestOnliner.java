package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Constant;
import utils.DriverManager;
import utils.OnlinerHelper;

import java.util.List;

public class TestOnliner extends DriverManager{

    private OnlinerHelper onliner;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        onliner = new OnlinerHelper();
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void testAddNewProductToCart(){
        onliner.openOnlinerShop();
        onliner.login(Constant.EMAIL, Constant.PASSWORD);
        onliner.openCatalog();
        onliner.chooseRandomCategory();
        String productName = onliner.chooseRandomProductFromCatalog();
        onliner.chooseRandomOffer();
        onliner.openCart();
        List <WebElement> productsFromCart = onliner.getProductsFromCart();
        for (WebElement productCart : productsFromCart) {
            productCart = onliner.getProductInfoFromCart();
            String nameOfProductFromCart = productCart.getText();
            if (nameOfProductFromCart.equals(productName)) {
                Assert.assertEquals(nameOfProductFromCart, productName);
            }
        }
    }
}
