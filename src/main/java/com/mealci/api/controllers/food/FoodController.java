package com.mealci.api.controllers.food;

import an.awesome.pipelinr.Pipeline;
import com.mealci.api.configuration.entrypoints.OpenApiConfiguration;
import com.mealci.core.food.Food;
import com.mealci.core.food.FoodService;
import com.mealci.core.food.create.CreateFoodRequest;
import com.mealci.core.food.delete.DeleteFoodCommand;
import com.mealci.core.food.delete.DeleteFoodResponse;
import com.mealci.core.food.get_foods.GetFoodResponse;
import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.food_state.FoodState;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final Pipeline pipeline;
    private final FoodService foodService;

    public FoodController(Pipeline pipeline, FoodService foodService) {
        this.pipeline = pipeline;
        this.foodService = foodService;
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @PostMapping("create")
    public ResponseEntity<Food> create(@RequestBody CreateFoodRequest request) {
        var result = foodService.create(request);

        return ResponseEntity.ok(result);
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @PostMapping("create/batch")
    public ResponseEntity<List<Food>> createBatch(@RequestBody List<CreateFoodRequest> request) {
        var result = foodService.batchCreate(request);

        return ResponseEntity.ok(result);
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @PatchMapping("state/{id}/{state}")
    public ResponseEntity<Food> updateState(@PathVariable("id") int id,
                                            @PathVariable("state") FoodState state) {
        var result = foodService.patchFoodState(id, state);

        return ResponseEntity.ok(result);
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @GetMapping("getFoods")
    public ResponseEntity<List<GetFoodResponse>> getFoods() {
        var result = foodService.getFoods();

        return ResponseEntity.ok(result);
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @GetMapping("getFoodsByCategory")
    public ResponseEntity<List<GetFoodResponse>> getFoodsByCategory(@RequestParam("category") FoodCategory category) {
        var result = foodService.getFoodsByCategory(category);

        return ResponseEntity.ok(result);
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @DeleteMapping("deleteFood")
    public ResponseEntity<Void> deleteFood(@RequestParam("id") int id) {
        new DeleteFoodCommand(id).execute(pipeline);

        return ResponseEntity.ok().build();
    }
}
