package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPageListsList {
    private ElementsCollection listElements = $$(By.xpath("//div[@data-id]"));
    private ContextMenu contextMenu;

    public ShoppingPageListsList deleteList(String name) {
        SelenideElement listElement = listElements.findBy(Condition.text(name));
        listElement.$(By.xpath(".//button")).click();
        contextMenu = new ContextMenu();
        contextMenu.clickDelete();

        return new ShoppingPageListsList();
    }

    public Boolean checkIfUserHasList(String name) {
        return listElements.findBy(Condition.text(name)).exists();
    }

    private class ContextMenu {
        private SelenideElement deleteButton = $(By.xpath("//button[@data-testid='shopping-list-delete-menu-button']"));

        public void clickDelete() {
            deleteButton.click();
        }
    }
}
