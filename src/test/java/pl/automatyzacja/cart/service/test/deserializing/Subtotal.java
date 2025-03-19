package pl.automatyzacja.cart.service.test.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Subtotal {

    @JsonProperty("1")
    private Double subtotal1;

    public Double getSubtotal() {return subtotal1; }
}
