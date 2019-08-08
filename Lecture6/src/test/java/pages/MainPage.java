package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constant;

public class MainPage extends BasicPage{

    private static final String CSS_SELECTOR_LOGIN_BTN_ON_MAIN_PAGE = ".auth-bar__item--text";
    private static final String XPATH_OPEN_CATALOG_BTN = "//a[@href='https://catalog.onliner.by/']";

    public MainPage(){
        System.out.println(driver.getCurrentUrl());
        if(!driver.getCurrentUrl().equals(Constant.ONLINER_URL)){
        driver.get(Constant.ONLINER_URL); }
    }

    public LoginPage openLoginPage() {
        driver.findElement(By.cssSelector(CSS_SELECTOR_LOGIN_BTN_ON_MAIN_PAGE)).click();
        return new LoginPage();
    }

    public ChaptersCatalogPage openCatalog() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_OPEN_CATALOG_BTN))).click();
        return new ChaptersCatalogPage();
    }
}