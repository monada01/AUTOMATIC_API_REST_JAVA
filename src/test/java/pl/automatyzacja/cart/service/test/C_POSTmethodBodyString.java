package pl.automatyzacja.cart.service.test;

import org.junit.Test;

public class C_POSTmethodBodyString {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyString(){
        Integer productId = 142;
        Integer quantity = 10;
        Boolean returnCart = true;
        String endpoint = "/cocart/v1/add-item";

        String bodyRequest = "{\n" +
                "    \"product_id\": " + productId +",\n" +
                "   \"quantity\": "+ quantity +",\n" +
                "   \"return_cart\": "+ returnCart +" \n" +
                "}";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
        }

    @Test
    public void calculateWithBodyString(){
        Boolean calculate = true;

        String endpoint = "/cocart/v1/calculate";

        String bodyRequest = "{\n" +
                "    \"returns\" : true\n" +
                "}";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

    @Test
    public void addItemWithBodyString2(){
        Integer productId = 142;
        Integer quantity = 5;
        Boolean returnCart = true;

        String endpoint = "/cocart/v1/add-item";

        String bodyRequest = "{\n" +
                "    \"product_id\": " + productId +",\n" +
                "   \"quantity\": "+ quantity +",\n" +
                "   \"return_cart\": "+ returnCart +" \n" +
                "}";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

    @Test
    public void updateWithBodyString2(){
        String cart_item_key = "a8baa56554f96369ab93e4f3bb068c22";
        Integer quantity = 15;
        Boolean returnCart = true;

        String endpoint = "/cocart/v1/item";

        String bodyRequest = "{\n" +
                "    \"cart_item_key\": " + cart_item_key +",\n" +
                "   \"quantity\": "+ quantity +",\n" +
                "   \"return_cart\": "+ returnCart +" \n" +
                "}";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }
}

