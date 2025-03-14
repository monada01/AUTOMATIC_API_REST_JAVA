package pl.automatyzacja.cart.service.test;

import io.restassured.response.Response;
import org.junit.Test;

public class F_GETmethod {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void getCart() {
        String endpoint = "/cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint);
        response.getBody().prettyPrint();
    }

    @Test
    public void coutItems() {
        String endpoint = "/cocart/v1/count-items";

        Response response = serviceHelper.sendGetRequest(endpoint);
        response.getBody().print();
    }

    @Test
    public void restoreItemToCartWithParams() {
        String key = "a8baa56554f96369ab93e4f3bb068c22";
        Boolean returnCart = true;
        String endpoint = "/cocart/v1/item";
        //String params = "?cart_item_key=a8baa56554f96369ab93e4f3bb068c22&return_cart=true";
        String params = "?cart_item_key=" + key + "&return_cart=" + returnCart;

        Response response = serviceHelper.sendGetRequest(endpoint + params);
        response.getBody().print();
    }

    @Test
    public void restoreItemToCartBody() {
        String bodyRequest = "{\n" +
                "    \"cart_item_key\" : \"a8baa56554f96369ab93e4f3bb068c22\",\n" +
                "    \"return_cart\" : true\n" +
                "}";
        String endpoint = "/cocart/v1/item";


        Response response = serviceHelper.sendGetRequest(bodyRequest, endpoint);
        response.getBody().print();
    }

    @Test
    public void totalItem() {
        String endpoint = "/cocart/v1/totals";
        String params = "?html=true";
        //String endpoint = "/cocart/v1/totals?html=true";

        Response response = serviceHelper.sendGetRequest(endpoint + params);
        //Response response = serviceHelper.sendGetRequest(endpoint);
        response.getBody().print();
    }
}
