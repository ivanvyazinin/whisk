package pageobject;

import com.codeborne.selenide.SelenideElement;
import models.ShoppingList;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement shoppingTab = $(By.xpath("//div[@data-testid='shopping-list-nav-link']"));

    public ShoppingPage goToShopping(){
        shoppingTab.click();
        return new ShoppingPage();
    }
}
