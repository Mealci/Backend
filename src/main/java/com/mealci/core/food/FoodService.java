package com.mealci.core.food;

import com.mealci.core.food.create.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    Food create(CreateFoodRequest request);
    List<Food> batchCreate(List<CreateFoodRequest> request);
}
