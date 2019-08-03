package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constant;

public class MainPage extends BasicPage{

    public MainPage() {
    }

    public void openOnlinerShop(){
        driver.get(Constant.ONLINER_URL);
    }

    public LoginPage openLoginPage() {
        driver.findElement(By.cssSelector(Constant.CSS_SELECTOR_LOGIN_BTN_ON_MAIN_PAGE)).click();
        return new LoginPage();
    }

    public ChaptersCatalogPage openCatalog() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constant.XPATH_OPEN_CATALOG_BTN))).click();
        return new ChaptersCatalogPage();
    }
}
