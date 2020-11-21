package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPage {
    private SelenideElement createNewListButton = $(By.xpath("//a[@data-testid='create-new-shopping-list-button']"));
    private SelenideElement newListNameInput = $(By.xpath("//input[@data-testid='UI_KIT_INPUT']"));
    private SelenideElement createButton = $(By.xpath("//button[@data-testid='create-new-shopping-list-create-button']"));
    private SelenideElement addItemInput = $(By.xpath("//input[@data-testid='desktop-add-item-autocomplete']"));

    private ElementsCollection itemsList = $$(By.xpath("//span[@data-testid='shopping-list-item-name']"));
    private ShoppingPageListsList shoppingPageListsList;

    public ShoppingPage createList(String name) {
        createNewListButton.click();
        newListNameInput.sendKeys(name);
        createButton.click();
        return new ShoppingPage();
    }

    public ShoppingPage deleteList(String name) {
        shoppingPageListsList = new ShoppingPageListsList();
        shoppingPageListsList.deleteList(name);
        return new ShoppingPage();
    }

    public void addItemToList(String item) {
        addItemInput.sendKeys(item);
        addItemInput.pressEnter();
    }

    public boolean checkIfItemIsInList(String item) {
        return itemsList.findBy(Condition.text(item)).exists();
    }

    public Boolean checkIfUserHasList(String name) {
        return shoppingPageListsList.checkIfUserHasList(name);
    }
}
