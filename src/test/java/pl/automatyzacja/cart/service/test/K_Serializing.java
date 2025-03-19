package pl.automatyzacja.cart.service.test;

import io.restassured.response.Response;
import org.junit.Test;
import pl.automatyzacja.cart.service.test.serializing.AddItemToCartRequestPOJO;

public class K_Serializing {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItem(){
        Integer productId = 142;
        Integer quantity = 1;
        Boolean returnCart = true;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);

        System.out.println(response.getBody().prettyPrint());
    }
}
