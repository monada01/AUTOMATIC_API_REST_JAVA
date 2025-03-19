package pl.automatyzacja.cart.service.test;

import java.util.Map;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import pl.automatyzacja.cart.service.test.deserializing.AddItemResponse;

public class L_Deserializing {

    final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemResponseDeserializing(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        AddItemResponse responseBody = response.as(AddItemResponse.class);

        System.out.println(responseBody.getKey());
        System.out.println(responseBody.getQuantity());
        System.out.println(responseBody.getDataHash());
        System.out.println(responseBody.getProductName());

        //Map<String, String> total = (Map<String, String>) responseBody.getLineTaxData().getTotal();
        //Object tot = total.get("1");
        //System.out.println(tot.toString());

        System.out.println(responseBody.getLineTaxData().getTotal().getTotal1());
    }
}
