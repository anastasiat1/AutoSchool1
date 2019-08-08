package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    System.setProperty(Constant.CHROME_DRIVER, "chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty(Constant.FIREFOX_DRIVER, "geckodriver");
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Specified browser is not supported!");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}