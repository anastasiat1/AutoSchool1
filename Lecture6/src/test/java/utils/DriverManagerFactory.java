package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerFactory {

    public static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "geckodriver");
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