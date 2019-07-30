package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OnlinerHelper {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Utils utils;

    public OnlinerHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        utils = new Utils(driver);
    }

    public void openFullScreenShop(String url){
        driver.get(url);
        utils.setFullScreen();
    }

    public void login(String email, String password) {
        driver.findElement(By.cssSelector(Constant.CSS_SELECTOR_LOGIN_BTN_ON_MAIN_PAGE)).click();
        driver.findElement(By.cssSelector(Constant.CSS_SELECTOR_INPUT_EMAIL)).sendKeys(email);
        driver.findElement(By.cssSelector(Constant.CSS_SELECTOR_INPUT_PASSWORD)).sendKeys(password);
        driver.findElement(By.cssSelector(Constant.CSS_SELECTOR_SUBMIT_BTN)).submit();
    }

    public void openCatalog() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constant.XPATH_OPEN_CATALOG_BTN))).click();
    }

    public void chooseFromCategory() {
        List<WebElement> globalCategory = driver.findElements(By.className(Constant.CLASSNAME_GLOBAL_CATEGORY));
        int globalCategoryIndex = (int) (Math.random() * globalCategory.size());
        globalCategory.get(globalCategoryIndex).click();
        WebElement selectedCatalogBlock = driver.findElement(By.xpath(Constant.XPATH_GLOBAL_CATEGORY_BLOCK));
        List<WebElement> asideCategory = selectedCatalogBlock.findElements(By.className(Constant.CLASSNAME_ASIDE_CATEGORY));
        int asideCategoryIndex = (int) (Math.random() * asideCategory.size());
        asideCategory.get(asideCategoryIndex).click();
        WebElement activeCategory = driver.findElement(By.className(Constant.CLASSNAME_ASIDE_CATEGORY_ITEM));
        wait.until(ExpectedConditions.elementToBeClickable(By.className(Constant.CLASSNAME_DROPDOWN_CATEGORY)));
        List<WebElement> activeCategoryChapters = activeCategory.findElements(By.className(Constant.CLASSNAME_DROPDOWN_CATEGORY));
        int activeCategoryChaptersIndex = (int) (Math.random() * activeCategoryChapters.size());
        wait.until(ExpectedConditions.elementToBeClickable(activeCategoryChapters.get(activeCategoryChaptersIndex))).click();
    }

    public String chooseProduct(){
        List<WebElement> products = driver.findElements(By.className(Constant.CLASSNAME_GROUPS_OF_PRODUCTS));
        int productsIndex = (int) (Math.random() * products.size());
        WebElement product = products.get(productsIndex);
        WebElement nameElement = product.findElement(By.xpath(Constant.XPATH_CATALOG_PRODUCT_NAME));
        String name = nameElement.getText();
        WebElement productBtn = product.findElement(By.xpath(Constant.XPATH_PRODUCT));
        productBtn.click();
        return name;
    }

    public void chooseOffer(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constant.CLASSNAME_OFFERS_LIST)));
        List<WebElement> cartBtn = driver.findElements(By.className(Constant.CLASSNAME_OFFERS_LIST));
        int cartIndex = (int) (Math.random() * cartBtn.size());
        cartBtn.get(cartIndex).click();
    }

    public void openCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constant.ID_CART))).click();
    }

    public List<WebElement> getProductsFromCart() {
        return driver.findElements(By.className(Constant.CLASSNAME_LIST_PRODUCTS_IN_CART));
    }

    public WebElement getProductNameFromCart(){
        return driver.findElement(By.xpath(Constant.XPATH_CART_PRODUCT_NAME));
    }
}