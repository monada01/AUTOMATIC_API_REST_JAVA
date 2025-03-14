package pl.automatyzacja.cart.service.test;

import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import org.json.JSONObject;
import org.junit.Test;

public class D_POSTmethodBodyJSONObject {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyJSONObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 10);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void calculateWithBodyJSONObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void updateItemWithBodyJSONObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        bodyRequest.put("quantity", 2);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/item";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }
}