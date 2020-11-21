package test.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobject.MainPage;
import pageobject.ShoppingPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static utils.DataGenerator.getRandomName;

public class ShoppingListUiTest extends BaseUiTest {

    private ShoppingPage shoppingPage;
    private String listName;

    @BeforeEach
    void prepareTestData() {
        listName = getRandomName();
        MainPage mainPage = login();
        shoppingPage = mainPage.goToShopping();
        shoppingPage.createList(listName);
    }

    @Test
    void createListTest() {
        shoppingPage.addItemToList("sugar");
        shoppingPage.addItemToList("milk");
        shoppingPage.addItemToList("eggs");
        shoppingPage.addItemToList("bread");
        shoppingPage.addItemToList("water");

        assertAll(
                () -> assertThat(shoppingPage.checkIfItemIsInList("milk")).isTrue(),
                () -> assertThat(shoppingPage.checkIfItemIsInList("sugar")).isTrue(),
                () -> assertThat(shoppingPage.checkIfItemIsInList("eggs")).isTrue(),
                () -> assertThat(shoppingPage.checkIfItemIsInList("bread")).isTrue(),
                () -> assertThat(shoppingPage.checkIfItemIsInList("water")).isTrue()
        );
    }

    @Test
    void deleteListTest() {
        shoppingPage.deleteList(listName);
        shoppingPage.checkIfUserHasList(listName);
    }
}
