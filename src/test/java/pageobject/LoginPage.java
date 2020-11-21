package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement emailInput = $(By.name("username"));
    private SelenideElement continueButton = $(By.xpath("//button[@data-testid='auth-continue-button']"));

    private SelenideElement passwordInput = $(By.name("password"));
    private SelenideElement loginButton = $(By.xpath("//button[@data-testid='auth-login-button']"));

    public LoginPage enterEmail(String email) {
        emailInput.sendKeys(email);
        continueButton.click();
        return new LoginPage();
    }

    public MainPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MainPage();
    }
}
