package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.DriverManagerFactory.getDriver;

public abstract class BasicPage {

    public static WebDriverWait wait;
    public static WebDriver driver;

    public BasicPage() {
        driver = getDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
    }
}
