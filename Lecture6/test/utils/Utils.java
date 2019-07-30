package utils;

import org.openqa.selenium.WebDriver;

public class Utils {

    private static WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void setFullScreen(){
        driver.manage().window().fullscreen();
    }
}