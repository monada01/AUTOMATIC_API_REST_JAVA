package pl.automatyzacja.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class G_DELETEmethod {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void removeItemFromCart() {
        String endpoint = "/cocart/v1/item";
        String params = "?cart_item_key=a8baa56554f96369ab93e4f3bb068c22&return_cart=true";

        Response response = serviceHelper.sendDeleteRequest(endpoint + params);
        //response.then().statusCode(200);
        response.getBody().prettyPrint();
    }

    @Test
    public void removeItemFromCart2() {
        JSONObject bodyRequestDelete = new JSONObject();
        bodyRequestDelete.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        bodyRequestDelete.put("return_cart", true);

        String endpoint = "/cocart/v1/item";
        serviceHelper.sendDeleteRequest(bodyRequestDelete.toString(), endpoint);
    }

    @Test
    public void removeItemFromCartWithBody() {
        String endpoint = "/cocart/v1/item";
        String bodyRequest = "{\n" +
                "    \"cart_item_key\" : \"a8baa56554f96369ab93e4f3bb068c22\",\n" +
                "    \"return_cart\" : \"true\"\n" +
                "}";

        Response response = serviceHelper.sendDeleteRequest(bodyRequest, endpoint);
        response.getBody().prettyPrint();
    }
}
