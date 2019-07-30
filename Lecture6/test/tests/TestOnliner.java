package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Constant;
import utils.OnlinerHelper;

import java.util.List;

public class TestOnliner {

    private OnlinerHelper onliner;
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        onliner = new OnlinerHelper(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testAddNewProductToCart(){
        onliner.openFullScreenShop(Constant.ONLINER_URL);
        onliner.login(Constant.EMAIL, Constant.PASSWORD);
        onliner.openCatalog();
        onliner.chooseFromCategory();
        String productName = onliner.chooseProduct();
        onliner.chooseOffer();
        onliner.openCart();
        List <WebElement> productsFromCart = onliner.getProductsFromCart();
        for (WebElement productCart : productsFromCart) {
            productCart = onliner.getProductNameFromCart();
            String nameOfProductFromCart = productCart.getText();
            if (nameOfProductFromCart.equals(productName)) {
                Assert.assertEquals(nameOfProductFromCart, productName);
            }
        }
    }
}
