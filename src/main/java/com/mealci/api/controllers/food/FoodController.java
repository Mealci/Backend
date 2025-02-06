package com.mealci.api.controllers.food;

import com.mealci.core.food.Food;
import com.mealci.core.food.FoodService;
import com.mealci.core.food.create.CreateFoodRequest;
import com.mealci.core.food_state.FoodState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("create")
    public ResponseEntity<Food> create(@RequestBody CreateFoodRequest request) {
        var result = foodService.create(request);

        return ResponseEntity.ok(result);
    }

    @PostMapping("create/batch")
    public ResponseEntity<List<Food>> createBatch(@RequestBody List<CreateFoodRequest> request) {
        var result = foodService.batchCreate(request);

        return ResponseEntity.ok(result);
    }

    @PatchMapping("state/{id}/{state}")
    public ResponseEntity<Food> updateState(@PathVariable("id") int id,
                                            @PathVariable("state") FoodState state) {
        var result = foodService.patchFoodState(id, state);

        return ResponseEntity.ok(result);
    }

    @GetMapping("getFoods")
    public ResponseEntity<List<Food>> getFoods() {
        var result 
    }
}
