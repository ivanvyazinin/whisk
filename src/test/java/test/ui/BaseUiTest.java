package test.ui;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static env.Configuration.getWhiskConfig;
import static properties.Constants.TEST_EMAIL;
import static properties.Constants.TEST_PASSWORD;

public class BaseUiTest {

    @BeforeAll
    static void init(){
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver1.exe");

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

    protected MainPage login(){
        open(getWhiskConfig().getFrontUrl());
        LoginPage loginPage = new LoginPage();
        loginPage = loginPage.enterEmail(TEST_EMAIL);
        return loginPage.enterPassword(TEST_PASSWORD);
    }

    @AfterAll()
    static void clean(){
        closeWebDriver();
    }
}
