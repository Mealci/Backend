package com.mealci.core.food;

import com.mealci.core.food.create.CreateFoodRequest;
import com.mealci.core.results.Result;

public interface FoodService {
    Result<Food> create(CreateFoodRequest request);
}
