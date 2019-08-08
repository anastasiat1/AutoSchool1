import buisnessObjects.Product;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Constant;
import utils.DriverManagerFactory;

import java.util.List;

public class TestOnliner extends DriverManagerFactory {

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void testAddNewProductToCart() {
        MainPage mainPage = new MainPage();
        ProductPage productPage = mainPage.openLoginPage()
                .login(Constant.EMAIL, Constant.PASSWORD)
                .openCatalog()
                .chooseRandomCategory()
                .chooseRandomProductFromCatalog();
        productPage.chooseRandomOffer();
        CartPage cartPage = productPage.openCart();
        List<WebElement> productsFromCart = cartPage.getProductsFromCart();
        Product newProduct = Product.getFirstProduct();
        Assert.assertTrue(cartPage.isProductPresent(productsFromCart, newProduct.getName()));
    }
}