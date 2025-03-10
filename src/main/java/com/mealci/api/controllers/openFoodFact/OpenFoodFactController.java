package com.mealci.api.controllers.openFoodFact;

import com.mealci.api.models.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OpenFoodFactController {

    @GetMapping("/getProduct")
    public ResponseEntity<String> getProduct(@RequestParam String barcode) {
        log.info("Get Product called ");
        String apiUrl = "https://world.openfoodfacts.org/api/v2/product/" + barcode;
        log.info("Fetching product from: " + apiUrl);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ProductResponse response = restTemplate.getForObject(apiUrl, ProductResponse.class);
            log.info("Product fetched: " + response);
            if (response != null && response.getProduct() != null) {
                log.info("Product found: " + response.getProduct().getProductName());
                String result = "Product: " + response.getProduct().getProductName() +
                        "\nIngredients: " + response.getProduct().getIngredientsText();
                return ResponseEntity.ok(result);
            }
            return ResponseEntity.status(404).body("Product not found");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching product: " + e.getMessage());
        }
    }
}