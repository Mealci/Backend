package com.mealci.core.food;

import com.mealci.core.food.create.CreateFoodRequest;
import com.mealci.core.results.Result;

import java.util.List;

public interface FoodService {
    Result<Food> create(CreateFoodRequest request);
    Result<List<Food>> batchCreate(List<CreateFoodRequest> request);
}
