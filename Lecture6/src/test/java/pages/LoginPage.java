package pages;

import org.openqa.selenium.By;
import utils.Constant;

public class LoginPage extends BasicPage {

    public LoginPage() {
    }

    public void login(String email, String password) {
        driver.findElement(By.cssSelector(Constant.CSS_SELECTOR_INPUT_EMAIL)).sendKeys(email);
        driver.findElement(By.cssSelector(Constant.CSS_SELECTOR_INPUT_PASSWORD)).sendKeys(password);
        driver.findElement(By.cssSelector(Constant.CSS_SELECTOR_SUBMIT_BTN)).submit();
    }

}
