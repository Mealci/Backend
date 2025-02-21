package com.mealci.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {

    @JsonProperty("product")
    private Product product;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        @JsonProperty("product_name")
        private String productName;

        @JsonProperty("ingredients_text")
        private String ingredientsText;
    }
}