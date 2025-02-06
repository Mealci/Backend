package com.mealci.dal.food.repositories;

import com.mealci.core.food.Food;

import java.util.List;

public interface CustomFoodRepository {
    Food create(Food food, String email);
    List<Food> batchCreate(List<Food> foods, String email);
}
