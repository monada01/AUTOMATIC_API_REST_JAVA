package pl.automatyzacja.cart.service.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class B_PostmethodBodyFormData {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFormData(){
        Integer productId = 142;
        Integer quantity = 10;
        Boolean returnCart = true;

        String endpoint = "/cocart/v1/get-cart";

        serviceHelper.addItem(productId, quantity, returnCart, endpoint);
    }

    @Test
    public void addItemWithBodyMap(){
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", "142");
        queryParamsBody.put("quantity", "5");
        queryParamsBody.put("return_cart", "true");

        String endpoint = "/cocart/v1/get-cart";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void calculateWithBodyMap(){
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("return", "true");

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void AddItemWithBodyMap2(){
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", "142");
        queryParamsBody.put("quantity", "1");
        queryParamsBody.put("return_cart", "true");

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void UpdateItemWithBodyMap(){
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        queryParamsBody.put("quantity", "10");
        queryParamsBody.put("return_cart", "true");

        String endpointUpdate = "/cocart/v1/item";

        serviceHelper.sendPostRequest(queryParamsBody, endpointUpdate);
    }
}
