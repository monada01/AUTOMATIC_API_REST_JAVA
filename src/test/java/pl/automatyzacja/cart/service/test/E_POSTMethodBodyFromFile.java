package pl.automatyzacja.cart.service.test;

import net.minidev.json.JSONObject;
import org.junit.Test;
import utils.JsonRequestBodyHelper;

public class E_POSTMethodBodyFromFile {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFromFile(){
        JSONObject bodyRequest = JsonRequestBodyHelper.getJsonFromFile("request-shop-add-item-to-card", "add_item_body");

        String endpoint = "/cocart/v1/add-item";
        serviceHelper.sendPostRequest(bodyRequest.toJSONString(), endpoint);
    }

    @Test
    public void updateItemWithBodyFromFile(){
        JSONObject bodyRequest = JsonRequestBodyHelper.getJsonFromFile("request-shop-update-quantity", "update_body");

        String endpoint = "/cocart/v1/item";
        serviceHelper.sendPostRequest(bodyRequest.toJSONString(), endpoint);
    }
}
