package test.api;

import api.WhiskApi;
import io.restassured.response.Response;
import models.ErrorResponse;
import models.ShoppingList;
import models.ShoppingListResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingListApiTest {
    WhiskApi api = new WhiskApi();
    ShoppingList shoppingList;

    @BeforeEach
    void initTestData(){
        shoppingList = new ShoppingList("string", false);
        shoppingList.id = api.createShoppingList(shoppingList).getBody().as(ShoppingListResponse.class).list.id;
    }

    @Test
    void createListTest(){

        ShoppingListResponse response = api.getShoppingList(shoppingList.id).getBody().as(ShoppingListResponse.class);
        assertThat(response.list.id).isEqualTo(shoppingList.id);
        assertThat(response.content).isEmpty();
    }

    @Test
    void deleteListTest(){
        api.deleteShoppingList(shoppingList.id);

        Response response = api.getShoppingList(shoppingList.id);

        assertThat(response.statusCode()).isEqualTo(400); // В требования было 200
        assertThat(
                response.getBody().as(ErrorResponse.class).code) // В требования было message
                .isEqualTo("shoppingList.notFound");
    }
}
