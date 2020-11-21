package api;

import env.WhiskConfig;
import io.restassured.response.Response;
import models.ShoppingList;

import java.util.HashMap;
import java.util.Map;

import static env.Configuration.getWhiskConfig;
import static utils.HttpMethods.*;

public class WhiskApi {
    private WhiskConfig config = getWhiskConfig();

    private String SHOPPING_LIST_ENDPOINT = "/list/v2";

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", config.getToken());
        return headers;
    }

    public Response createShoppingList(ShoppingList body) {
        return postRequest(config.getHost() + SHOPPING_LIST_ENDPOINT, getHeaders(), body);
    }

    public Response getShoppingList(String id) {
        return getRequest(config.getHost() + SHOPPING_LIST_ENDPOINT + "/" + id, getHeaders());
    }

    public Response deleteShoppingList(String id) {
        return deleteRequest(config.getHost() + SHOPPING_LIST_ENDPOINT + "/" + id, getHeaders());
    }

}
