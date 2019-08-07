package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage {

    @FindBy(css = "input.auth-input[type=text]")
    private WebElement inputEmail;

    @FindBy(css = "input.auth-input[type=password]")
    private WebElement inputPassword;

    @FindBy(css = "button.auth-button[type=submit]")
    private WebElement submitBtn;

    public MainPage login(String email, String password, MainPage mainPage) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        submitBtn.submit();
        return mainPage;
    }
}