package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OnlinerHelper extends DriverManager{
    private static WebDriverWait wait;
    private static Utils utils;

    public OnlinerHelper() {
        utils = new Utils();
        wait = new WebDriverWait(getDriver(), 15);
        getDriver().manage().window().maximize();
    }

    public void openOnlinerShop(){
        getDriver().get(Constant.ONLINER_URL);
    }

    public void login(String email, String password) {
        getDriver().findElement(By.cssSelector(Constant.CSS_SELECTOR_LOGIN_BTN_ON_MAIN_PAGE)).click();
        getDriver().findElement(By.cssSelector(Constant.CSS_SELECTOR_INPUT_EMAIL)).sendKeys(email);
        getDriver().findElement(By.cssSelector(Constant.CSS_SELECTOR_INPUT_PASSWORD)).sendKeys(password);
        getDriver().findElement(By.cssSelector(Constant.CSS_SELECTOR_SUBMIT_BTN)).submit();
    }

    public void openCatalog() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constant.XPATH_OPEN_CATALOG_BTN))).click();
    }

    public void chooseRandomCategory() {
        List<WebElement> globalCategory = getDriver().findElements(By.className(Constant.CLASSNAME_GLOBAL_CATEGORY));
        globalCategory.get(utils.chooseRandomElement(globalCategory)).click();
        WebElement selectedCatalogBlock = getDriver().findElement(By.xpath(Constant.XPATH_GLOBAL_CATEGORY_BLOCK));
        List<WebElement> asideCategory = selectedCatalogBlock.findElements(By.className(Constant.CLASSNAME_ASIDE_CATEGORY));
        asideCategory.get(utils.chooseRandomElement(asideCategory)).click();
        WebElement activeCategory = getDriver().findElement(By.className(Constant.CLASSNAME_ASIDE_CATEGORY_ITEM));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constant.CLASSNAME_DROPDOWN_CATEGORY)));
        List<WebElement> activeCategoryChapters = activeCategory.findElements(By.className(Constant.CLASSNAME_DROPDOWN_CATEGORY));
        wait.until(ExpectedConditions.elementToBeClickable(activeCategoryChapters.get(utils.chooseRandomElement(activeCategoryChapters)))).click();
    }

    public String chooseRandomProductFromCatalog(){
        List<WebElement> products = getDriver().findElements(By.className(Constant.CLASSNAME_GROUPS_OF_PRODUCTS));
        WebElement product = products.get(utils.chooseRandomElement(products));
        WebElement nameElement = product.findElement(By.xpath(Constant.XPATH_CATALOG_PRODUCT_NAME));
        String name = nameElement.getText();
        WebElement productBtn = product.findElement(By.xpath(Constant.XPATH_PRODUCT));
        productBtn.click();
        return name;
    }

    public void chooseRandomOffer(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constant.CLASSNAME_OFFERS_LIST)));
        List<WebElement> cartBtn = getDriver().findElements(By.className(Constant.CLASSNAME_OFFERS_LIST));
        cartBtn.get(utils.chooseRandomElement(cartBtn)).click();
    }

    public void openCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constant.ID_CART))).click();
    }

    public List<WebElement> getProductsFromCart() {
        return getDriver().findElements(By.className(Constant.CLASSNAME_LIST_PRODUCTS_IN_CART));
    }

    public WebElement getProductInfoFromCart(){
        return getDriver().findElement(By.xpath(Constant.XPATH_CART_PRODUCT_INFO));
    }

}