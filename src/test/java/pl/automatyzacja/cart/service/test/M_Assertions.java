package pl.automatyzacja.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pl.automatyzacja.cart.service.test.deserializing.AddItemResponse;
import pl.automatyzacja.cart.service.test.serializing.AddItemToCartRequestPOJO;

import java.util.HashMap;
import java.util.Map;

public class M_Assertions {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemAndCheck() {
        Integer productId = 142;
        Integer quantity = 1;
        Boolean returnCart = false;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);

        AddItemResponse responseBody = response.as(AddItemResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("15.00NBSPzł", responseBody.getProductPrice());//ze skopiowaną spacją twardą z odpowiedzi z testu
        Assertions.assertEquals(142, responseBody.getProductId());
        Assertions.assertEquals("Bransoletka", responseBody.getProductName());
    }

    @Test
    public void updateItemAndCheck() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", "142");
        queryParamsBody.put("quantity", "5");
        queryParamsBody.put("return_cart", "true");

        String endpoint = "/cocart/v1/get-cart";

        Response response = serviceHelper.sendPostRequest(queryParamsBody, endpoint);

        String key = response.getBody().jsonPath().getString("key");

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("cart_item_key", key);
        bodyRequest.put("quantity", 10);
        String endpointUpdate = "/cocart/v1/item";

        Response responseUpdate = serviceHelper.sendPostRequest(bodyRequest.toString(), endpointUpdate);

        Assertions.assertEquals(200, responseUpdate.getStatusCode());
        Assertions.assertEquals(10, responseUpdate.getBody().jsonPath().getInt("quantity"));
    }
}
