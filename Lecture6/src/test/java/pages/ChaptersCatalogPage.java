package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

import java.util.List;

public class ChaptersCatalogPage extends BasicPage {

    private static final String CLASSNAME_GLOBAL_CATEGORY = "catalog-navigation-classifier__item";
    private static final String XPATH_GLOBAL_CATEGORY_BLOCK = "//div[@class=\"catalog-navigation-list__category\" and @style=\"display: block;\"]";
    private static final String XPATH_ASIDE_CATEGORY = ".//div[contains(@class,'catalog-navigation-list__aside-item')]";
    private static final String XPATH_ASIDE_CATEGORY_ITEM = ".//div[contains(@class,'catalog-navigation-list__aside-item_active')]";
    private static final String XPATH_DROPDOWN_CATEGORY = ".//div[contains(@class,'catalog-navigation-list__dropdown-list')]";
    private static final String XPATH_DROPDOWN_ITEM = ".//a[contains(@class,'catalog-navigation-list__dropdown-item')]";

    public ProductsCatalogPage chooseRandomCategory() {
        List<WebElement> globalCategory = driver.findElements(By.className(CLASSNAME_GLOBAL_CATEGORY));
        globalCategory.get(Utils.getRandomIndex(0, globalCategory.size()-1)).click();
        WebElement selectedCatalogBlock = driver.findElement(By.xpath(XPATH_GLOBAL_CATEGORY_BLOCK));
        List<WebElement> asideCategory = selectedCatalogBlock.findElements(By.xpath(XPATH_ASIDE_CATEGORY));
        builder.moveToElement(asideCategory.get(Utils.getRandomIndex(0, asideCategory.size()-1))).build().perform();
        WebElement activeCategory = driver.findElement(By.xpath(XPATH_ASIDE_CATEGORY_ITEM));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_DROPDOWN_CATEGORY)));
        List<WebElement> activeCategoryChapters = activeCategory.findElements(By.xpath(XPATH_DROPDOWN_ITEM));
        wait.until(ExpectedConditions.elementToBeClickable(activeCategoryChapters.get(Utils.getRandomIndex(0, activeCategoryChapters.size()-1)))).click();
        return new ProductsCatalogPage();
    }
}