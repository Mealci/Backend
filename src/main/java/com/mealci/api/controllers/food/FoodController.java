package com.mealci.api.controllers.food;

import com.mealci.core.food.FoodService;
import com.mealci.core.food.create.CreateFoodRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody CreateFoodRequest request) {
        var result = foodService.create(request);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result.getErrorCode());
        }

        return ResponseEntity.ok(result.getValue());
    }

    @PostMapping("create/batch")
    public ResponseEntity<?> createBatch(@RequestBody List<CreateFoodRequest> request) {
        var result = foodService.batchCreate(request);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result.getErrorCode());
        }

        return ResponseEntity.ok(result.getValue());
    }
}
