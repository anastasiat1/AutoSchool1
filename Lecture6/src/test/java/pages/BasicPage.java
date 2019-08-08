package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.DriverManagerFactory.getDriver;

public abstract class BasicPage {

    public static WebDriverWait wait;
    public static WebDriver driver;
    public static Actions builder;

    public BasicPage() {
        driver = getDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        PageFactory.initElements(this.driver, this);
        builder = new Actions(driver);
    }
}