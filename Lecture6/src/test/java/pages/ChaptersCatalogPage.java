package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constant;
import utils.Utils;

import java.util.List;

public class ChaptersCatalogPage extends BasicPage {

    public ChaptersCatalogPage() {
    }

    public ProductsCatalogPage chooseRandomCategory() {
        List<WebElement> globalCategory = driver.findElements(By.className(Constant.CLASSNAME_GLOBAL_CATEGORY));
        globalCategory.get(Utils.chooseRandomElement(globalCategory)).click();
        WebElement selectedCatalogBlock = driver.findElement(By.xpath(Constant.XPATH_GLOBAL_CATEGORY_BLOCK));
        List<WebElement> asideCategory = selectedCatalogBlock.findElements(By.className(Constant.CLASSNAME_ASIDE_CATEGORY));
        asideCategory.get(Utils.chooseRandomElement(asideCategory)).click();
        WebElement activeCategory = driver.findElement(By.className(Constant.CLASSNAME_ASIDE_CATEGORY_ITEM));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constant.CLASSNAME_DROPDOWN_CATEGORY)));
        List<WebElement> activeCategoryChapters = activeCategory.findElements(By.className(Constant.CLASSNAME_DROPDOWN_CATEGORY));
        wait.until(ExpectedConditions.elementToBeClickable(activeCategoryChapters.get(Utils.chooseRandomElement(activeCategoryChapters)))).click();
        return new ProductsCatalogPage();
    }
}
