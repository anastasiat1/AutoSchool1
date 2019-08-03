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
        mainPage.openOnlinerShop();
        LoginPage loginPage = mainPage.openLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        ChaptersCatalogPage chaptersCatalogPage = mainPage.openCatalog();
        ProductsCatalogPage productsCatalogPage = chaptersCatalogPage.chooseRandomCategory();
        String productName = productsCatalogPage.getNameOfProductFromCatalog();
        ProductPage productPage = productsCatalogPage.getRandomProductFromCatalog();
        productPage.chooseRandomOffer();
        CartPage cartPage = productPage.openCart();
        List<WebElement> productsFromCart = cartPage.getProductsFromCart();
        for (WebElement productCart : productsFromCart) {
            productCart = cartPage.getProductInfoFromCart();
            String nameOfProductFromCart = productCart.getText();
            if (nameOfProductFromCart.equals(productName)) {
                Assert.assertEquals(nameOfProductFromCart, productName);
            }
        }
    }
}
