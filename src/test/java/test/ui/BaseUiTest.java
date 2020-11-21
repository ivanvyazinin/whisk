package test.ui;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static env.Configuration.getWhiskConfig;
import static properties.Constants.TEST_EMAIL;
import static properties.Constants.TEST_PASSWORD;

public class BaseUiTest {

    @BeforeEach
    void init() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        ChromeDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        open(getWhiskConfig().getFrontUrl());
    }

    protected MainPage login() {
        open(getWhiskConfig().getFrontUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(TEST_EMAIL);
        return loginPage.enterPassword(TEST_PASSWORD);
    }

    @AfterEach()
    void clean() {
        closeWebDriver();
    }
}
