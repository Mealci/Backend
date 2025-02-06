package com.mealci.core.food;

import com.mealci.core.food.create.CreateFoodRequest;
import com.mealci.core.food.get_foods.GetFoodResponse;
import com.mealci.core.food_state.FoodState;

import java.util.List;

public interface FoodService {
    Food create(CreateFoodRequest request);
    List<Food> batchCreate(List<CreateFoodRequest> request);
    Food patchFoodState(int id, FoodState state);
    List<GetFoodResponse> getFoods();
}
